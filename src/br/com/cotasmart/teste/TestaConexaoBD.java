package br.com.cotasmart.teste;

import java.sql.SQLException;

import br.com.cotasmart.factory.CreateFactory;

public class TestaConexaoBD {

	public static void main(String[] args) throws SQLException {
		CreateFactory c = new CreateFactory();
		
		c.criarTabelas();
		
	}
}
