package br.usjt.domain.contracts.repositories;

public interface BaseRepository<T> {
    void create(T data);

    T getByKey(String key, String value);
}
