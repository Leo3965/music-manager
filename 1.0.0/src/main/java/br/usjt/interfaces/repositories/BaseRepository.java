package br.usjt.interfaces.repositories;

import java.util.List;

public interface BaseRepository<T> {
    void create(T data);

    void update(T data);

    List<T> getByKey(String key, String value);
}
