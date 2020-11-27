package br.usjt.factories.repository;

import br.usjt.factories.drivers.MysqlDriverFactory;
import br.usjt.interfaces.repositories.UserRepository;
import br.usjt.repository.UserRepositoryImpl;


public class UserRepositoryFactory {
    public static UserRepository get() {
        return new UserRepositoryImpl(MysqlDriverFactory.get());
    }
}
