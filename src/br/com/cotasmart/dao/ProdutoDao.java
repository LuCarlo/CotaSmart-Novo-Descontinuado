package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Produto;

public class ProdutoDao {
	private Connection connection;

	public ProdutoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Produto produto){
		String sql = "INSERT INTO produtos ("+
					 "nome, codStatus, codGrupoProdutos) " +
					 "VALUES (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, produto.getNome());
			stmt.setLong(2, produto.getCodStatus());
			stmt.setLong(3, produto.getCodGrupoProdutos());
			
			stmt.execute();
			
		} catch (SQLException e) {
			System.out.println("Falha ao inserir produto: "+e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
