package br.usjt.infrastructure.contracts;

public interface SQLConnector {
    void connect();

    void runQuery(String query);

    void disconnect();

    void select(String query);
}
