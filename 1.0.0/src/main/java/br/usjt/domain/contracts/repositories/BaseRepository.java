package br.usjt.domain.contracts.repositories;

import java.util.List;

public interface BaseRepository<T> {
    void create(T data);

    List<T> getByKey(String key, String value);
}
