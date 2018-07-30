package main;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import modelo.Articulo;
import modelo.Etiqueta;
import modelo.Notificacion;
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
import servicios.enums.TipoNotificacion;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;
import utilidades.JsonUtilidades;
import utilidades.UsuarioRest;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import static spark.Spark.*;

public class Rutas {

    private static final String pass = "parcial2";


    public void manejoRutas() {

        File uploadDir = new File("fotos");
        uploadDir.mkdir();

        Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Rutas.class, "/templates");

        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        path("/rest", () -> {

            path("/usuarios", () -> {

                get("/", (request, response) -> {

                    List<Usuario> usuarioList = new CRUD<Usuario>().findAll(Usuario.class);

                    List<UsuarioRest> usuarioRests = new ArrayList<>();

                    for (Usuario usuario : usuarioList) {

                        usuarioRests.add(new UsuarioRest(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getUsername()));

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
            Session session = HibernateUtil.getSession();

            if (llaveValor.length > 1 && obtenerUsuarioSesion(request) == null) {

                BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
                textEncryptor.setPassword(pass);

                System.out.println(llaveValor[0] + " contra: " + llaveValor[1]);
                String user = textEncryptor.decrypt(llaveValor[0]);
                String contra = textEncryptor.decrypt(llaveValor[1]);


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

            Usuario usuario = obtenerUsuarioSesion(request);
            if (obtenerUsuarioSesion(request) != null) {
                List<Notificacion> list = session.createQuery("select n from Notificacion n where n.destino = :usuario and n.leido = :leido")
                        .setParameter("usuario", usuario)
                        .setParameter("leido", false)
                        .setMaxResults(7).list();

                attributes.put("list2", list);
            }

            session.close();

            attributes.put("usuario", usuario);


            return new ModelAndView(attributes, "inicio.ftl");
        }, freeMarkerEngine);


        post("/registrar", (request, response) -> {

            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String correo = request.queryParams("email");
            String password = request.queryParams("password");
            String username = request.queryParams("username");


            Usuario usuario = new Usuario(nombre, apellido, correo, password, username, Date.from(Instant.now()), false, "");

            guardarUsuarioSesion(usuario, request);

            new CRUD<Usuario>().save(usuario);
            response.redirect("/terminarPerfil");

            return "";
        });

        post("/publicar", (request, response) -> {

            String foto = rutaFoto("foto", uploadDir, request);
            String titulo = request.queryParams("titulo");
            String descripcion = request.queryParams("descripcion");

            String etiquetas = request.queryParams("etiquetas");
            String publico = request.queryParams("publico");




            Articulo articulo = new Articulo(titulo, descripcion, obtenerUsuarioSesion(request), Date.from(Instant.now()), publico != null);
            Session session = HibernateUtil.getSession();

            if (!foto.isEmpty()){
                articulo.setFoto(foto);
            }

            String[] etiqueta = etiquetas.split(",");


            String[] texto = descripcion.split(" ");

            Set<Notificacion> notificacionSet = new HashSet<>();
            Set<String> menciones = new HashSet<>();
            for (String s : texto) {

                if (s.startsWith("@")) {
                    String user = s.replace('@', ' ');
                    user = user.trim();

                    menciones.add(user);
                }

            }

            for (String s: menciones) {

                Usuario usuario = (Usuario) session.createQuery("select u from Usuario u where u.username = :user").setParameter("user", s).uniqueResult();
                if (usuario != null) {

                    Notificacion notificacion = new Notificacion(TipoNotificacion.MENCION, articulo, obtenerUsuarioSesion(request), usuario, Date.valueOf(LocalDate.now()), false);
                    notificacionSet.add(notificacion);
                }

            }

            session.close();


            Set<Etiqueta> etiquetaSet = new HashSet<>();

            for (String s : etiqueta) {
                Etiqueta etiqueta1 = new Etiqueta(s, articulo);
                etiquetaSet.add(etiqueta1);
            }


            articulo.setEtiquetaSet(etiquetaSet);
            articulo.setNotificacionSet(notificacionSet);

            new CRUD<Articulo>().save(articulo);

            response.redirect("/");
            return "";
        });


        get("/perfil/:id", (request, response) -> "llego");

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
            if (obtenerUsuarioSesion(request) != null) {
                List<Notificacion> list = session.createQuery("select n from Notificacion n where n.destino = :usuario and n.leido = :leido")
                        .setParameter("usuario", obtenerUsuarioSesion(request))
                        .setParameter("leido", false)
                        .setMaxResults(7).list();


                attributes.put("list2", list);
                attributes.put("cantidadNotificaciones", list.size());
            }


            template.process(attributes, writer);

            session.close();

            return writer;
        });

        get("/post/:post", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            String id = request.params("post");
            System.out.println("id : " +id);

            Articulo articulo = new CRUD<Articulo>().findByID(Articulo.class, Long.valueOf(id));

            DateTime inicio = new DateTime(articulo.getFechaCreacion());
            DateTime fin = new DateTime(Date.valueOf(LocalDate.now()));

            Session session = HibernateUtil.getSession();
            if (obtenerUsuarioSesion(request) != null) {
                List<Notificacion> list = session.createQuery("select n from Notificacion n where n.destino = :usuario and n.leido = :leido")
                        .setParameter("usuario", obtenerUsuarioSesion(request))
                        .setParameter("leido", false)
                        .setMaxResults(7).list();

                attributes.put("list2", list);
            }

            session.close();

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

            String sql = "select u from Usuario u where u.username = :username and u.contrasena = :pass";
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

                response.redirect("/");
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

    public static String rutaFoto(String campo, File direccion, Request request) throws IOException {

        Path tempFile = Files.createTempFile(direccion.toPath(), "", "");

        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

        try (InputStream input = request.raw().getPart(campo).getInputStream()) {

            System.out.println(request.raw().getPart(campo).getSubmittedFileName());

            if(request.raw().getPart(campo).getSubmittedFileName().isEmpty()){
                return "-1";
            }
            Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (ServletException e) {
            e.printStackTrace();
            return "-1";
        }

        return "/" + tempFile.getFileName().toString();
    }

}
