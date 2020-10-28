package br.usjt;

import org.hibernate.Session;

import br.usjt.domain.entity.User;
import br.usjt.utils.HibernateUtil;

public class App {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            // User user = new User("Luciano Souza Santos", "llwigp62");

            // session.save(user);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
