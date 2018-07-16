package servicios;

import freemarker.template.Configuration;
import freemarker.template.Version;

import static spark.Spark.*;

public class Rutas {

    public void manejoRutas(){

        Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Rutas.class, "/templates");

        get("/inicio", (request, response) -> {

            return "";
        });
    }


}
