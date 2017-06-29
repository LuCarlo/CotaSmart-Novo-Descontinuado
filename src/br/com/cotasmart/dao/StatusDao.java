package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Status;

public class StatusDao {
	private Connection connection;

	public StatusDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			System.out.println("Erro no construtor StatusDao");
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Status status) {
		String sql = "INSERT INTO status (nome) VALUES (?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, status.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro no SQL: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}
}
