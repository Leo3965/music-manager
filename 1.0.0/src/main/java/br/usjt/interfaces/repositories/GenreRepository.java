package br.usjt.interfaces.repositories;

import java.util.List;

import br.usjt.entity.Genre;
import br.usjt.entity.User;

public interface GenreRepository extends BaseRepository<Genre> {
    List<Genre> getByUser(User user);

    List<Genre> getAll();
}
