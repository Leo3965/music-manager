package br.usjt.factories.domain;

import br.usjt.domain.services.UserService;
import br.usjt.factories.infrastructure.drivers.HashDriverFactory;
import br.usjt.factories.infrastructure.repository.UserRepositoryFactory;

public class UserServiceFactory {

    public static UserService get() {
        return new UserService(UserRepositoryFactory.get(), HashDriverFactory.get());
    }
}
