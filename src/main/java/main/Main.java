package main;

import modelo.Lugar;
import modelo.Usuario;
import servicios.Rutas;
import servicios.db.BootstrapService;
import servicios.db.hibernate.CRUD;
import servicios.enums.TipoLugar;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws SQLException {


        BootstrapService.startDb();

        staticFiles.location("/templates");


        new CRUD<Usuario>().save(new Usuario("admin", "admin",  Date.from(Instant.now()), "Santiago"));

        Usuario usuario = new CRUD<Usuario>().findByID(Usuario.class, 1L);

        new CRUD<Lugar>().save(new Lugar("Aqui", Date.from(Instant.now()), Date.from(Instant.now()), usuario, TipoLugar.ESTUDIO));
        new Rutas().manejoRutas();

    }
}
