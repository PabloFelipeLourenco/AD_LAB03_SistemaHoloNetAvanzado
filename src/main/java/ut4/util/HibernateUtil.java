/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.util;

/**
 *
 * @author pablo
 */
import ut4.modelo.Nave;
import ut4.modelo.Planeta;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = crearSessionFactory();

    private static SessionFactory crearSessionFactory() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(Planeta.class)
                .addAnnotatedClass(Nave.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        if (SESSION_FACTORY != null && !SESSION_FACTORY.isClosed()) {
            SESSION_FACTORY.close();
        }
    }
}
