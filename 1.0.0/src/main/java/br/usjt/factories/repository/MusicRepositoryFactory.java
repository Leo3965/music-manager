package br.usjt.factories.repository;

import br.usjt.factories.services.MysqlDriverFactory;
import br.usjt.interfaces.repositories.MusicRepository;
import br.usjt.repository.MusicRepositoryImpl;

public class MusicRepositoryFactory {
    public static MusicRepository get() {
        return new MusicRepositoryImpl(MysqlDriverFactory.get());
    }
}
