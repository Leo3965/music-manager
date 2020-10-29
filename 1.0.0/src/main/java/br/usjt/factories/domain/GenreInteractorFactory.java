package br.usjt.factories.domain;

import br.usjt.domain.interactor.GenreInteractors;
import br.usjt.factories.infrastructure.repository.GenreRepositoryFactory;

public class GenreInteractorFactory {
    public static GenreInteractors get() {
        return new GenreInteractors(GenreRepositoryFactory.get());
    }
}
