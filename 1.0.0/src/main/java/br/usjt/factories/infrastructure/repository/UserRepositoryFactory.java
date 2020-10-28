package br.usjt.factories.infrastructure.repository;

import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.infrastructure.repository.UserRepositoryImpl;
import br.usjt.utils.HibernateUtil;

public class UserRepositoryFactory {
    public static UserRepository get() {
        return new UserRepositoryImpl(HibernateUtil.getEntityManager());
    }
}
