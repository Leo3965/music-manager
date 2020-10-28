package br.usjt.infrastructure.repository;

import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.domain.entity.User;
import br.usjt.infrastructure.contracts.SQLConnector;

public class UserRepositoryImpl implements UserRepository {

    private SQLConnector sql;

    UserRepositoryImpl(SQLConnector sql) {
        this.sql = sql;
    }

    public void create(User data) {
        this.sql.runQuery("INSERT INTO users ");
    }

    public User getByKey(String key, String value) {
        return null;
    }
}
