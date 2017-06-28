package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cotasmart.factory.ConnectionFactory;
import br.com.cotasmart.modelo.Fornecedor;

public class FornecedorDao {
	private Connection connection;

	public FornecedorDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Fornecedor fornecedor) {
		
		
		String sql = "INSERT INTO fornecedores ("+
					"nomeFornecedor, endereco, telefone1, telefone2, telefone3, cnjp) "+
					"VALUES (?,?,?,?,?,?) ";
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNomeFornecedor());
			stmt.setString(2, fornecedor.getEndereco());
			stmt.setString(3, fornecedor.getTelefone1());
			stmt.setString(4, fornecedor.getTelefone2());
			stmt.setString(5, fornecedor.getTelefone3());
			stmt.setString(6, fornecedor.getCnpj());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Fornecedor fornecedor){
		String sql = "update fornecedores set nomeFornecedor=?, endereco=?, telefone1=?," +
						"telefone2=?, telefone3=?, cnpj=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNomeFornecedor());
			stmt.setString(2, fornecedor.getEndereco());
			stmt.setString(3, fornecedor.getTelefone1());
			stmt.setString(4, fornecedor.getTelefone2());
			stmt.setString(5, fornecedor.getTelefone3());
			stmt.setString(6, fornecedor.getCnpj());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
			
					
	}
	
	public void remove(Fornecedor fornecedor){
		String sql = "delete from fornecedores where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, fornecedor.getCodFornecedor());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public boolean verificaSeExiste(String cnpj){
		String sql = "Select 1 from fornecedores where cnpj=?"; 
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cnpj);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		
		}
		
		return false;
	}
}
