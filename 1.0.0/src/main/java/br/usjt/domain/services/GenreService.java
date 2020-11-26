package br.usjt.domain.services;

import br.usjt.domain.contracts.repositories.GenreRepository;
import br.usjt.domain.entity.Genre;
import br.usjt.domain.entity.User;
import java.util.List;

public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenresByUser(User user) {
        return this.genreRepository.getByUser(user);
    }

    public List<Genre> getAll() {
        return this.genreRepository.getAll();
    }

    public List<Genre> getByKey(String key, String value) {
        return this.genreRepository.getByKey(key, value);
    }
}
