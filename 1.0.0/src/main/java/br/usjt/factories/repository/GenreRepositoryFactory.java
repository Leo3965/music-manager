package br.usjt.factories.repository;

import br.usjt.factories.drivers.MysqlDriverFactory;
import br.usjt.interfaces.repositories.GenreRepository;
import br.usjt.repository.GenreRepositoryImpl;


public class GenreRepositoryFactory {
    public static GenreRepository get() {
        return new GenreRepositoryImpl(MysqlDriverFactory.get());
    }
}
