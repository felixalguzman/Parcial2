package main;

import modelo.Usuario;
import servicios.Rutas;
import servicios.db.BootstrapService;
import servicios.db.hibernate.CRUD;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;

import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args) throws SQLException {


        BootstrapService.startDb();

        staticFiles.location("/templates");


         new CRUD<Usuario>().save(new Usuario("admin", "admin", "felixlvl@gmail.com", "1234", "admin", Date.from(Instant.now())));



        new Rutas().manejoRutas();

    }
}
