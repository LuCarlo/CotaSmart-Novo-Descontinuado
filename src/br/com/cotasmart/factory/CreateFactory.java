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
					"cod_status INTEGER, "+
					"nome CHARACTER VARYING (20), "+
					"tipo CHARACTER VARYING (1),"+
					"CONSTRAINT pk_status PRIMARY KEY (cod_status)); "+
					" "+
					"CREATE TABLE  IF NOT EXISTS grupos_usuario ( "+
					"cod_grupo INTEGER, "+
					"nome CHARACTER VARYING (20),"+
					"CONSTRAINT pk_grupos_usuario PRIMARY KEY (cod_grupo)"
					+ ");"+
					" "+
					"CREATE TABLE IF NOT EXISTS usuarios ( "+
					"cod_usuario INTEGER NOT NULL, "+
					"nome CHARACTER VARYING(50), "+
					"login CHARACTER VARYING (20), "+
					"senha CHARACTER VARYING (10), "+
					"cod_status INTEGER REFERENCES status ON DELETE CASCADE, "+
					"cod_grupo INTEGER REFERENCES grupos_usuario ON DELETE CASCADE, "+
					"CONSTRAINT pk_usuario PRIMARY KEY (cod_usuario));" +
					" "+
					"CREATE TABLE IF NOT EXISTS uf ( "+
					"cod_uf INTEGER, "+
					"uf CHARACTER VARYING (2), "+
					"CONSTRAINT pk_uf PRIMARY KEY (cod_uf));"+
					" "+
					"CREATE TABLE IF NOT EXISTS cidades ( "+
					"cod_cidade INTEGER, "+
					"nome CHARACTER VARYING (20), "+
					"cod_uf INTEGER REFERENCES uf ON DELETE CASCADE, "+
					"CONSTRAINT pk_cidades PRIMARY KEY (cod_cidade));"+
					" "+
					"CREATE TABLE IF NOT EXISTS fornecedores ("+
					"cod_fornecedor INTEGER,"+
					"nome CHARACTER VARYING (50), "+
					"endereco CHARACTER VARYING (100), "+
					"cod_cidade INTEGER REFERENCES cidades ON DELETE CASCADE, "+
					"telefone1 CHARACTER VARYING(20), "+
					"telefone2 CHARACTER VARYING(20), "+
					"telefone3 CHARACTER VARYING(20), "+
					"cod_usuario INTEGER REFERENCES grupos_usuario ON DELETE CASCADE, "+
					"cod_status INTEGER REFERENCES status ON DELETE CASCADE, "+
					"CONSTRAINT pk_fornecedores PRIMARY KEY cod_fornecedor);"+
					" "+
					"CREATE TABLE IF NOT EXISTS grupo_produtos ( "+
					"cod_grupo_produtos INTEGER, "+
					"nome CHARACTER VARYING(20));"+
					" "+
					"CREATE TABLE IF NOT EXISTS produtos ( "+
					"cod_produto INTEGER, "+
					"nome CHARACTER VARYING (50), "+
					"cod_status INTEGER REFERENCES status ON DELETE CASCADE, "+
					"cod_grupo_produtos REFERENCES grupo_produtos ON DELETE CASCADE, "+
					"CONSTRAINT pk_produtos PRIMARY KEY produtos);"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacao ( "+
					"cod_cotacao INTEGER, "+
					"data DATETIME, "+
					"cod_usuario INTEGER REFERENCES usuarios ON DELETE CASCADE, "+
					"cod_status INTEGER REFERENCES status ON DELETE CASCADE	);"+
					" "+
					"CREATE TABLE IF NOT EXISTS cotacao_produtos ( "+
					"cod_cotacao_produtos INTEGER, "+
					"cod_cotacao INTEGER REFERENCES cotacao ON DELETE CASCADE, "+
					"cod_produto INTEGER REFERENCES produtos ON DELETE CASCADE, " +
					"cod_fornecedor INTEGER REFERENCES fornecedores ON DELETE CASCADE);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.execute();	
		} catch (SQLException e) {
			System.out.println("Erro ao criar tabelas "+e.getMessage());
			throw new RuntimeException(e);
		}
		
	}
}
