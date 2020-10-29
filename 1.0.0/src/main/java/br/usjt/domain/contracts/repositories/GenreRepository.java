package br.usjt.domain.contracts.repositories;

import java.util.List;

import br.usjt.domain.entity.Genre;
import br.usjt.domain.entity.User;

public interface GenreRepository extends BaseRepository<Genre> {
    List<Genre> getByUser(User user);

    List<Genre> getAll();
}
