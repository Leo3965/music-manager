package br.usjt.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDriver {
    private String host;
	private String port;
	private String db;
	private String user;
    private  String pass;
    
    public MysqlDriver(String host, String port, String db, String user, String pass) {
        this.host = host;
        this.port = port;
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

	public Connection getConnection() throws Exception {
		String url = String.format("jdbc:mysql://%s:%s/%s", host,
				port, db);
		return DriverManager.getConnection(url, user, pass);
	}
}
