package br.usjt.factories.infrastructure.repository;

import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.infrastructure.repository.UserRepositoryImpl;

public class UserRepositoryFactory {
    public static UserRepository get() {
        return new UserRepositoryImpl();
    }
}