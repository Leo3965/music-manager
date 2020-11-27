package br.usjt.factories.services;

import br.usjt.services.GenreService;
import br.usjt.factories.repository.GenreRepositoryFactory;

public class GenreServiceFactory {
    public static GenreService get() {
        return new GenreService(GenreRepositoryFactory.get());
    }
}
