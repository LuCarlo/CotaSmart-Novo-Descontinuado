package br.com.cotasmart.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		String driver = "org.postgresql.driver";
		String usuario = "postgres";
		String senha = "";
		String url = "jdbc:postgresql://localhost:5432/CotaSmart";

		System.out.println("Conectando...");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		return DriverManager.getConnection(url, usuario, senha);
	}
}
