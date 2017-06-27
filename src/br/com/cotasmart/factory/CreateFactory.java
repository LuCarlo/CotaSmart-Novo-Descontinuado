package br.com.cotasmart.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateFactory {
	private Connection connection;
	
	public CreateFactory() throws SQLException {
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
					"CREATE TABLE  IF NOT EXISTS grupos_usuario ( "+
					"codGrupo INTEGER, "+
					"nome CHARACTER VARYING (20),"+
					"CONSTRAINT pk_grupos_usuario PRIMARY KEY (codGrupo)"
					+ ");"+
					" "+
					"CREATE TABLE IF NOT EXISTS usuarios ( "+
					"codUsuario INTEGER NOT NULL, "+
					"nome CHARACTER VARYING(50), "+
					"login CHARACTER VARYING (20), "+
					"senha CHARACTER VARYING (10), "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE, "+
					"codGrupo INTEGER REFERENCES grupos_usuario ON DELETE CASCADE, "+
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
					"codUsuario INTEGER REFERENCES grupos_usuario ON DELETE CASCADE, "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE, "+
					"CONSTRAINT pk_fornecedores PRIMARY KEY codFornecedor);"+
					" "+
					"CREATE TABLE IF NOT EXISTS grupo_produtos ( "+
					"codGrupo_produtos INTEGER, "+
					"nome CHARACTER VARYING(20));"+
					" "+
					"CREATE TABLE IF NOT EXISTS produtos ( "+
					"codProduto INTEGER, "+
					"nome CHARACTER VARYING (50), "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE, "+
					"codGrupo_produtos REFERENCES grupo_produtos ON DELETE CASCADE, "+
					"CONSTRAINT pk_produtos PRIMARY KEY produtos);"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacao ( "+
					"codCotacao INTEGER, "+
					"data DATETIME, "+
					"codUsuario INTEGER REFERENCES usuarios ON DELETE CASCADE, "+
					"codStatus INTEGER REFERENCES status ON DELETE CASCADE	);"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacao_produtos ( "+
					"codCotacao_produtos INTEGER, "+
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
