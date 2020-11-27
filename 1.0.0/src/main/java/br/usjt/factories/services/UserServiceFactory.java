package br.usjt.factories.services;

import br.usjt.services.UserService;
import br.usjt.factories.services.HashDriverFactory;
import br.usjt.factories.repository.UserRepositoryFactory;

public class UserServiceFactory {

    public static UserService get() {
        return new UserService(UserRepositoryFactory.get(), HashDriverFactory.get());
    }
}
