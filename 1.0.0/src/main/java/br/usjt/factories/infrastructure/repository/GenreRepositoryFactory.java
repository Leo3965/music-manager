package br.usjt.factories.infrastructure.repository;

import br.usjt.domain.contracts.repositories.GenreRepository;
import br.usjt.factories.infrastructure.drivers.MysqlDriverFactory;
import br.usjt.infrastructure.repository.GenreRepositoryImpl;


public class GenreRepositoryFactory {
    public static GenreRepository get() {
        return new GenreRepositoryImpl(MysqlDriverFactory.get());
    }
}
