package servicios;

import freemarker.template.Configuration;
import freemarker.template.Version;
import modelo.Articulo;
import modelo.Lugar;
import modelo.Usuario;
import org.hibernate.Session;
import org.jasypt.util.text.BasicTextEncryptor;
import servicios.db.hibernate.CRUD;
import servicios.db.hibernate.HibernateUtil;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static spark.Spark.get;
import static spark.Spark.post;

public class Rutas {

    private static final String pass = "parcial2";

    public void manejoRutas(){

        Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Rutas.class, "/templates");

        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/inicio", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();


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

            String descripcion = request.queryParams("descripcion");
            String foto = request.queryParams("file");
            String[] etiquetas = request.queryParamsValues("chips");

            Articulo articulo = new Articulo(descripcion, obtenerUsuarioSesion(request), Date.from(Instant.now()));
            new CRUD<Articulo>().save(articulo);


            return "";
        });

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

            if (usuario != null){

                request.session(true);
                guardarUsuarioSesion(usuario, request);

                if (recordar != null){

                    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
                    textEncryptor.setPassword(pass);

                    String usernameEncrypt = textEncryptor.encrypt(username);
                    String passEncrypt = textEncryptor.encrypt(contra);

                    response.cookie("/", "login", username + "," + passEncrypt, 604800, false);

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



    private void guardarUsuarioSesion(Usuario usuario, Request request){

        request.session(true);
        request.session().attribute("usuario", usuario);
    }

    private Usuario obtenerUsuarioSesion(Request request){


        return request.session().attribute("usuario");
    }


}
