package br.usjt.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder;

import br.usjt.domain.contracts.repositories.GenreRepository;
import br.usjt.domain.entity.Genre;
import br.usjt.domain.entity.User;

public class GenreRepositoryImpl implements GenreRepository {

    private EntityManager em;

    public GenreRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Genre data) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Genre> getByKey(String key, String value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Genre> getByUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Genre> getAll() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Genre> cq = cb.createQuery(Genre.class);
        Root<Genre> rootEntry = cq.from(Genre.class);
        CriteriaQuery<Genre> all = cq.select(rootEntry);
        TypedQuery<Genre> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

}
