package edu.konrad.digiturnotest.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author lpajaro
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
        
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Error al establecer conexion con base de datos." + ex.toString());
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
