package servicios;

import freemarker.template.Configuration;
import freemarker.template.Version;
import modelo.Usuario;
import servicios.db.hibernate.CRUD;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Rutas {

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


            Usuario usuario = new Usuario(nombre, apellido, correo, password, username, Date.from(Instant.now()));

            guardarUsuarioSesion(usuario, request);

            new CRUD<Usuario>().save(usuario);
            response.redirect("/inicio");

            return "";
        });


        get("/iniciarSesion", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            String username = request.queryParams("username");
            String contra = request.queryParams("password");

            System.out.println(username + contra);

            String sql = "select * from Usuario u where u.USERNAME ='" +username + "' and u.CONTRASENA ='" + contra+"'";
            Usuario usuario = new CRUD<Usuario>().findOne(sql);

            if (usuario != null){

                request.session(true);
                guardarUsuarioSesion(usuario, request);

                response.redirect("/inicio");
            }



            return new ModelAndView(attributes, "404.ftl");
        }, freeMarkerEngine);


    }



    private void guardarUsuarioSesion(Usuario usuario, Request request){

        request.session(true);
        request.session().attribute("usuario", usuario);
    }

    private Usuario obtenerUsuarioSesion(Request request){


        return request.session().attribute("usuario");
    }


}
