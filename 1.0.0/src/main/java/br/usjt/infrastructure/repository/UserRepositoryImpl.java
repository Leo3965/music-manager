package br.usjt.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.domain.entity.User;

public class UserRepositoryImpl implements UserRepository {

    private EntityManager em;

    UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public void create(User data) {
        if (data.getId() == null) {
            em.persist(data);
        } else {
            em.merge(data);
        }
    }

    public List<User> getByKey(String key, String value) {
        TypedQuery<User> q = em.createQuery("SELECT b FROM Book b WHERE b." + key + " = :value", User.class);
        q.setParameter("value", value);
        return q.getResultList();
    }
}
