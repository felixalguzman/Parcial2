package main;

import servicios.Rutas;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {


        staticFiles.location("/templates");


        new Rutas();

    }
}
