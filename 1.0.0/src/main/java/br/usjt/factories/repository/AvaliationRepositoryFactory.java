package br.usjt.factories.repository;

import br.usjt.factories.services.MysqlDriverFactory;
import br.usjt.interfaces.repositories.AvaliationRepository;
import br.usjt.repository.AvaliationRepositoryImpl;

public class AvaliationRepositoryFactory {
    public static AvaliationRepository get() {
        return new AvaliationRepositoryImpl(MysqlDriverFactory.get());
    }
}
