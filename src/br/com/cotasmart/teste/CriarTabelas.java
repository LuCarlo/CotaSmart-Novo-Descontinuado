package br.com.cotasmart.teste;

import java.sql.SQLException;

import br.com.cotasmart.factory.CreationFactory;

public class CriarTabelas {

	public static void main(String[] args) throws SQLException {
		CreationFactory con = new CreationFactory();
		con.criarTabelas();
		System.out.println("Tabelas criadas");

	}

}
