package br.usjt.factories.infrastructure.drivers;

import br.usjt.infrastructure.drivers.MysqlDriver;

public class MysqlDriverFactory {
    public static MysqlDriver get() {
        return new MysqlDriver("us-cdbr-east-02.cleardb.com", "3306", "heroku_48bfef6cb4f5fe3", "b069a12087bfbc", "c1789f58");
    }
}
