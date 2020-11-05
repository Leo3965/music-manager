package br.usjt.infrastructure.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.domain.entity.User;
import br.usjt.utils.HibernateUtil;

public class UserRepositoryImpl implements UserRepository {

    public void create(User data) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(data);
        transaction.commit();
        session.close();
    }

    public List<User> getByKey(String key, String value) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(key), value));
        TypedQuery<User> query = session.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    public void update(User data) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(data);
        transaction.commit();
        session.close();
    }
}
