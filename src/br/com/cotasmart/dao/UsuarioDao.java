package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO usuarios (" + "nome, login, senha, codStatus, codGrupo) " + "VALUES (?,?,?,?,?) ";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setLong(4, usuario.getCodStatus());
			stmt.setLong(5, usuario.getCodGrupo());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
