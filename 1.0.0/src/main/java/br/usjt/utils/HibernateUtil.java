package br.usjt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    public static EntityManager getEntityManager() {
        try (Session session = getSessionFactory().openSession()) {
            return session.getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Session getSession() {
        try {
            return getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
