package servicios.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    /**
     * Funcion que contruye la sesion de hibernate para la interaccion con la base de datos
     * @return
     */
    private static SessionFactory buildSessionFactory(){
        SessionFactory sessionFactory = null;
        try{
            ServiceRegistry serviceRegistry;
            Configuration configuration = new  Configuration();
            configuration.configure("/Hibernate/hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();


        }catch (Exception e){
            e.printStackTrace();
        }
        return sessionFactory;
    }

    /**
     * Funcion que me devuelve la sessionfactory inicializada
     * @return
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    /**
     * Funcion que me devuelve la session actual
     * @return
     */
    public static Session getSession(){
        return sessionFactory.openSession();
    }
}