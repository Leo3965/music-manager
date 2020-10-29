package br.usjt.factories.infrastructure.repository;

import br.usjt.domain.contracts.repositories.GenreRepository;
import br.usjt.infrastructure.repository.GenreRepositoryImpl;
import br.usjt.utils.HibernateUtil;

public class GenreRepositoryFactory {
    public static GenreRepository get() {
        return new GenreRepositoryImpl(HibernateUtil.getEntityManager());
    }
}
