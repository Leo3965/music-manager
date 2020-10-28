package br.usjt.infrastructure.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.usjt.infrastructure.contracts.SQLConnector;

public class MySQLConnector implements SQLConnector {

    private String host;
    private String user;
    private String pass;
    private String database;
    private Connection connection;

    public MySQLConnector(String host, String user, String pass, String database) {
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.database = database;
    }

    public void connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.database, this.user,
                    this.pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runQuery(String query) {
        try (PreparedStatement ps = this.connection.prepareStatement(query);) {
            ps.execute();
            System.out.println(ps.getResultSet());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(String query) {
        try (Statement selectSt = this.connection.createStatement()) {

            ResultSet rs = selectSt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1)); // First Column
                System.out.println(rs.getString(2)); // Second Column
                System.out.println(rs.getString(3)); // Third Column
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void disconnect() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
