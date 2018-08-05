package main;

import static spark.Spark.before;

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