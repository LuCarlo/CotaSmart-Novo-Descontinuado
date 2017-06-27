package br.com.cotasmart.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreationFactory {
	private Connection connection;
	
	public CreationFactory() throws SQLException {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void criarTabelas() throws SQLException{
		String SQL = "CREATE TABLE IF NOT EXISTS status ( "+
					"codStatus INTEGER, "+
					"nome CHARACTER VARYING (20), "+
					"tipo CHARACTER VARYING (1),"+
					"CONSTRAINT pk_status PRIMARY KEY (codStatus)); "+
					" "+
					"CREATE TABLE  IF NOT EXISTS gruposUsuario ( "+
					"codGrupo INTEGER, "+
					"nome CHARACTER VARYING (20),"+
					"CONSTRAINT pk_grupos_usuario PRIMARY KEY (codGrupo));"+
					" "+
					"CREATE TABLE IF NOT EXISTS usuarios ( "+
					"codUsuario INTEGER NOT NULL, "+
					"nome CHARACTER VARYING(50), "+
					"login CHARACTER VARYING (20), "+
					"senha CHARACTER VARYING (10), "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE, "+
					"codGrupo INTEGER REFERENCES gruposUsuario ON DELETE CASCADE, "+
					"CONSTRAINT pk_usuario PRIMARY KEY (codUsuario));" +
					" "+
					"CREATE TABLE IF NOT EXISTS uf ( "+
					"codUf INTEGER, "+
					"uf CHARACTER VARYING (2), "+
					"CONSTRAINT pk_uf PRIMARY KEY (codUf));"+
					" "+
					"CREATE TABLE IF NOT EXISTS cidades ( "+
					"codCidade INTEGER, "+
					"nome CHARACTER VARYING (20), "+
					"codUf INTEGER REFERENCES uf ON DELETE CASCADE, "+
					"CONSTRAINT pk_cidades PRIMARY KEY (codCidade));"+
					" "+
					"CREATE TABLE IF NOT EXISTS fornecedores ("+
					"codFornecedor INTEGER,"+
					"nome CHARACTER VARYING (50), "+
					"endereco CHARACTER VARYING (100), "+
					"codCidade INTEGER REFERENCES cidades ON DELETE CASCADE, "+
					"telefone1 CHARACTER VARYING(20), "+
					"telefone2 CHARACTER VARYING(20), "+
					"telefone3 CHARACTER VARYING(20), "+
					"codUsuario INTEGER REFERENCES gruposUsuario ON DELETE CASCADE, "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE, "+
					"CONSTRAINT pk_fornecedores PRIMARY KEY (codFornecedor));"+
					" "+
					"CREATE TABLE IF NOT EXISTS grupoProdutos ( "+
					"codGrupoProdutos INTEGER, "+
					"nome CHARACTER VARYING(20),"+
					"CONSTRAINT pk_grupoProdutos PRIMARY KEY(codGrupoProdutos) );"+
					" "+
					"CREATE TABLE IF NOT EXISTS produtos ( "+
					"codProduto INTEGER, "+
					"nome CHARACTER VARYING (50), "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE, "+
					"codGrupoProdutos INTEGER REFERENCES grupoProdutos ON DELETE CASCADE, "+
					"CONSTRAINT pk_produtos PRIMARY KEY (codProduto));"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacao ( "+
					"codCotacao INTEGER, "+
					"data DATE, "+
					"codUsuario INTEGER REFERENCES usuarios ON DELETE CASCADE, "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE,"+
					"CONSTRAINT pk_cotacao PRIMARY KEY (codCotacao) );"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacaoProdutos ( "+
					"codCotacaoProdutos INTEGER, "+
					"codCotacao INTEGER REFERENCES cotacao ON DELETE CASCADE, "+
					"codProduto INTEGER REFERENCES produtos ON DELETE CASCADE, " +
					"codFornecedor INTEGER REFERENCES fornecedores ON DELETE CASCADE);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.execute();	
		} catch (SQLException e) {
			System.out.println("Erro ao criar tabelas "+e.getMessage());
			throw new RuntimeException(e);
		}
		
	}
}
