package main;

import static spark.Spark.staticFiles;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;

import org.hibernate.Session;

import modelo.Usuario;
import servicios.db.BootstrapService;
import servicios.db.hibernate.CRUD;
import servicios.db.hibernate.HibernateUtil;

public class Main {

    public static void main(String[] args) throws SQLException {

        

        BootstrapService.startDb();

        staticFiles.location("/templates");
        staticFiles.externalLocation("fotos");



        Session session = HibernateUtil.getSession();

        Usuario admin = (Usuario) session.createQuery("select u from Usuario u where u.admin = :admin").setParameter("admin", true).setMaxResults(1).uniqueResult();

        if (admin == null){
            new CRUD<Usuario>().save(new Usuario("admin", "admin", "felixlvl@gmail.com", "1234", "admin", Date.from(Instant.now()), true, "user"));

        }



        session.close();



        new Rutas().manejoRutas();
        new Filtros().aplicarFiltros();

    }
}
