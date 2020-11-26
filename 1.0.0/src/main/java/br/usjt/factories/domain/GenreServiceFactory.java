package br.usjt.factories.domain;

import br.usjt.domain.services.GenreService;
import br.usjt.factories.infrastructure.repository.GenreRepositoryFactory;

public class GenreServiceFactory {
    public static GenreService get() {
        return new GenreService(GenreRepositoryFactory.get());
    }
}
