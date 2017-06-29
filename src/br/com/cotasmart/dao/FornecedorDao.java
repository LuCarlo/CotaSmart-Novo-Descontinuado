package br.com.cotasmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					"nome, endereco, telefone1, telefone2, telefone3, cnjp) "+
					"VALUES (?,?,?,?,?,?) ";
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
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
		String sql = "update fornecedores set nome=?, endereco=?, telefone1=?," +
						"telefone2=?, telefone3=?, cnpj=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
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
	
	public List<Fornecedor> getLista(){
		try{
			List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
			PreparedStatement stmt = connection.prepareStatement("select * from fornecedores");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCodFornecedor(rs.getInt("codFornecedor"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setTelefone1(rs.getString("telefone1"));
				fornecedor.setTelefone2(rs.getString("telefone2"));
				fornecedor.setTelefone3(rs.getString("telefone3"));
				
				fornecedores.add(fornecedor);
			}
			rs.close();
			stmt.close();
			return fornecedores;
		}catch(SQLException e){
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
