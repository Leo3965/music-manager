package br.usjt.factories.services;

import br.usjt.services.MysqlDriver;

public class MysqlDriverFactory {
    public static MysqlDriver get() {
        return new MysqlDriver("localhost", "3306", "music_manager", "root", "secret");
    }
}
