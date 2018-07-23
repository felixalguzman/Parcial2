package main;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import modelo.Articulo;
import modelo.Etiqueta;
import modelo.Mencion;
import modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.jasypt.util.text.BasicTextEncryptor;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import servicios.db.hibernate.CRUD;
import servicios.db.hibernate.HibernateUtil;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;
import utilidades.JsonUtilidades;
import utilidades.UsuarioRest;

import java.io.StringWriter;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;

public class Rutas {

    private static final String pass = "parcial2";

    public void manejoRutas() {

        Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Rutas.class, "/templates");

        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        path("/rest", () -> {

            path("/usuarios", () -> {

                get("/", (request, response) -> {

                    List<Usuario> usuarioList = new CRUD<Usuario>().findAll(Usuario.class);

                    List<UsuarioRest> usuarioRests = new ArrayList<>();

                    for (Usuario usuario: usuarioList) {

                        usuarioRests.add(new UsuarioRest(usuario.getNombre(), usuario.getApellido(), usuario.getUsername()));

                    }

                    return usuarioRests;
                }, JsonUtilidades.json());
            });
        });

        get("/inicio", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            Map<String, String> cookies = request.cookies();

            String[] llaveValor = new String[2];
            request.cookie("login");

            for (String key : cookies.keySet()) {
                System.out.println("llave: " + key + " valor: " + cookies.get(key));
                llaveValor = cookies.get(key).split(",");

            }

            if (llaveValor.length > 1 && obtenerUsuarioSesion(request) == null) {

                BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
                textEncryptor.setPassword(pass);

                System.out.println(llaveValor[0] + " contra: " + llaveValor[1]);
                String user = textEncryptor.decrypt(llaveValor[0]);
                String contra = textEncryptor.decrypt(llaveValor[1]);

                Session session = HibernateUtil.getSession();

                Usuario usuario1 = (Usuario) session.createQuery("select u from Usuario u where u.username = :user and u.contrasena = :contra")
                        .setParameter("user", user)
                        .setParameter("contra", contra)
                        .uniqueResult();
                if (usuario1 != null) {

                    guardarUsuarioSesion(usuario1, request);
                    request.session(true);
                    response.redirect("/inicio");
                }
            }

            attributes.put("usuario", obtenerUsuarioSesion(request));

            return new ModelAndView(attributes, "inicio.ftl");
        }, freeMarkerEngine);


        post("/registrar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String correo = request.queryParams("email");
            String password = request.queryParams("password");
            String username = request.queryParams("username");


            Usuario usuario = new Usuario(nombre, apellido, correo, password, username, Date.from(Instant.now()), false);

            guardarUsuarioSesion(usuario, request);

            new CRUD<Usuario>().save(usuario);
            response.redirect("/terminarPerfil");

            return "";
        });

        post("/publicar", (request, response) -> {

            String titulo = request.queryParams("titulo");
            String descripcion = request.queryParams("descripcion");
            String foto = request.queryParams("file");
            String etiquetas = request.queryParams("etiquetas");
            String publico = request.queryParams("publico");

            Articulo articulo = new Articulo(titulo, descripcion, obtenerUsuarioSesion(request), Date.from(Instant.now()), publico != null);
            Session session = HibernateUtil.getSession();


            List<String> etiqueta = Arrays.asList(etiquetas.split(","));
            List<String> texto = Arrays.asList(descripcion.split(" "));

            Set<Mencion> mencionSet = new HashSet<>();

            for (String s: texto) {

                if (s.startsWith("@")){
                    String user = s.replace('@', ' ');
                    System.out.println("username de usuario:" + user);
                    Usuario usuario = (Usuario) session.createQuery("select u from Usuario u where u.username = :user").setParameter("user",user ).uniqueResult();
                    if (usuario != null){
                        System.out.println("usuario " + usuario.getId() + " " + usuario.getNombre());
                        mencionSet.add(new Mencion(obtenerUsuarioSesion(request), usuario));
                    }


                }

            }

            session.close();
            articulo.setMencions(mencionSet);



            Set<Etiqueta> etiquetaSet = new HashSet<>();

            for (String s : etiqueta) {
                Etiqueta etiqueta1 = new Etiqueta(s, articulo);
                etiquetaSet.add(etiqueta1);
            }


            articulo.setEtiquetaSet(etiquetaSet);

            new CRUD<Articulo>().save(articulo);

            response.redirect("/");
            return "";
        });

        get("/inicio/:pag", (request, response) -> {

            StringWriter writer = new StringWriter();
            Template template = configuration.getTemplate("posts.ftl");
            Map<String, Object> attributes = new HashMap<>();

            String p = request.params("pag");
            int pagina = Integer.parseInt(p);

            Session session = HibernateUtil.getSession();

            Query query;
            if (obtenerUsuarioSesion(request) == null) {
                query = session.createQuery("select a from Articulo a where a.publico=true order by a.id desc");

            } else {
                System.out.println("entro");
                query = session.createQuery("select a from Articulo a order by a.id desc");

            }
            query.setFirstResult((pagina - 1) * 5);
            query.setMaxResults(5);

            Criteria criteriaCount = session.createCriteria(Articulo.class);
            criteriaCount.setProjection(Projections.rowCount());
            Long cant = (Long) criteriaCount.uniqueResult();



            List<Articulo> articulos = query.list();

            attributes.put("list", articulos);
            attributes.put("actual", pagina);
            attributes.put("paginas", Math.ceil(cant / 5f));
            attributes.put("usuario", obtenerUsuarioSesion(request));


            template.process(attributes, writer);

            session.close();

            return writer;
        });

        get("/post/:id", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            String id = request.params("id");

            Articulo articulo = new CRUD<Articulo>().findByID(Articulo.class, Long.valueOf(id));

            DateTime inicio = new DateTime(articulo.getFechaCreacion());
            DateTime fin = new DateTime(Date.valueOf(LocalDate.now()));


            int min = Minutes.minutesBetween(fin, inicio).getMinutes() % 60;


            attributes.put("tiempoPublicado", " hace " + min + " minutos");


            attributes.put("usuario", obtenerUsuarioSesion(request));
            attributes.put("articulo", articulo);


            return new ModelAndView(attributes, "postDetalle.ftl");
        }, freeMarkerEngine);

        get("/terminarPerfil", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            attributes.put("usuario", obtenerUsuarioSesion(request));

            return new ModelAndView(attributes, "terminarPerfil.ftl");
        }, freeMarkerEngine);

        post("/terminar", (request, response) -> {

            String fechaNacimiento = request.queryParams("fechaNacimiento");
            String lugarNacimiento = request.queryParams("lugarNacimiento");
            String ciudad = request.queryParams("ciudad");

            Usuario usuario = obtenerUsuarioSesion(request);

            usuario.setFechaNacimiento(Date.valueOf(fechaNacimiento));

            usuario.setLugarNacimiento(lugarNacimiento);
            usuario.setCiudadActual(ciudad);

            new CRUD<Usuario>().update(usuario);

            response.redirect("/");


            return "";
        });


        get("/iniciarSesion", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            String username = request.queryParams("username");
            String contra = request.queryParams("password");
            String recordar = request.queryParams("recordar");

            System.out.println(username + contra);

            String sql = "from Usuario u where u.username = :username and u.contrasena = :pass";
            Session session = HibernateUtil.getSession();


            Usuario usuario = (Usuario) session.createQuery(sql).setParameter("username", username).setParameter("pass", contra).uniqueResult();

            if (usuario != null) {

                request.session(true);
                guardarUsuarioSesion(usuario, request);

                if (recordar != null) {

                    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
                    textEncryptor.setPassword(pass);

                    String usernameEncrypt = textEncryptor.encrypt(username);
                    String passEncrypt = textEncryptor.encrypt(contra);

                    response.cookie("/", "login", usernameEncrypt + "," + passEncrypt, 604800, false);

                }

                response.redirect("/inicio");
            }


            return new ModelAndView(attributes, "error.ftl");
        }, freeMarkerEngine);


        get("/logOut", (request, response) -> {

            spark.Session session = request.session(true);
            session.invalidate();
            response.removeCookie("/", "login");
            response.redirect("/");

            return "";
        });


    }


    private void guardarUsuarioSesion(Usuario usuario, Request request) {

        request.session(true);
        request.session().attribute("usuario", usuario);
    }

    private Usuario obtenerUsuarioSesion(Request request) {


        return request.session().attribute("usuario");
    }


}
