package main;

import org.jasypt.util.text.StrongTextEncryptor;

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