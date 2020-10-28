package br.usjt.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.domain.entity.User;

public class UserRepositoryImpl implements UserRepository {

    private EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
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
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(key), value));
        TypedQuery<User> query = this.em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
