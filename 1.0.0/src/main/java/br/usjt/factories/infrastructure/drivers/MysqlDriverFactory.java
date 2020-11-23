package br.usjt.factories.infrastructure.drivers;

import br.usjt.infrastructure.drivers.MysqlDriver;

public class MysqlDriverFactory {
    public static MysqlDriver get() {
        return new MysqlDriver("localhost", "3306", "music_manager", "root", "secret");
    }
}
