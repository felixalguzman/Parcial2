package main;

import modelo.Usuario;
import servicios.Rutas;
import servicios.db.BootstrapService;
import servicios.db.hibernate.CRUD;

import java.sql.SQLException;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws SQLException {


        BootstrapService.startDb();

        staticFiles.location("/templates");


        new CRUD<Usuario>().save(new Usuario(1, "admin", "admin", lugaresStudio));

        new Rutas().manejoRutas();

    }
}
