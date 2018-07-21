package servicios;

import static spark.Spark.*;

/**
 * Filtros
 */
public class Filtros {

    public void aplicarFiltros() {
        
        before("/", (request, response) -> {

            response.redirect("/inicio");

        });
    }
}