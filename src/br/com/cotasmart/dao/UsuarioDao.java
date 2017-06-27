package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Usuario;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void adiciona(Usuario usuario){

	}
}
