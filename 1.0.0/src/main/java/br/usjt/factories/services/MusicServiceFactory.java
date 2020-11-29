package br.usjt.factories.services;

import br.usjt.services.MusicService;
import br.usjt.factories.repository.AvaliationRepositoryFactory;
import br.usjt.factories.repository.MusicRepositoryFactory;

public class MusicServiceFactory {
    public static MusicService get() {
        return new MusicService(MusicRepositoryFactory.get(), AvaliationRepositoryFactory.get());
    }
}
