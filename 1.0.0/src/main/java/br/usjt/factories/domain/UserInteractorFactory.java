package br.usjt.factories.domain;

import br.usjt.domain.interactor.UserInteractors;
import br.usjt.factories.infrastructure.drivers.HashDriverFactory;
import br.usjt.factories.infrastructure.repository.UserRepositoryFactory;

public class UserInteractorFactory {

    public static UserInteractors get() {
        return new UserInteractors(UserRepositoryFactory.get(), HashDriverFactory.get());
    }
}
