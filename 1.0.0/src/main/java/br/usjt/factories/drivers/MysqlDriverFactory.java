package br.usjt.factories.drivers;

import br.usjt.drivers.MysqlDriver;

public class MysqlDriverFactory {
    public static MysqlDriver get() {
        return new MysqlDriver("localhost", "3306", "music_manager", "root", "secret");
    }
}
