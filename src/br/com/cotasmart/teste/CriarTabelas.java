package br.com.cotasmart.teste;

import java.sql.SQLException;

import br.com.cotasmart.factory.CreateFactory;

public class CriarTabelas {

	public static void main(String[] args) throws SQLException {
		CreateFactory con = new CreateFactory();
		con.criarTabelas();
		System.out.println("Tabelas criadas");

	}

}
