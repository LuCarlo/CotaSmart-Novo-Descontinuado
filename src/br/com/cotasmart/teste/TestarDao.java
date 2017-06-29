package br.com.cotasmart.teste;

import java.sql.SQLException;

import br.com.cotasmart.dao.StatusDao;
import br.com.cotasmart.factory.CreationFactory;
import br.com.cotasmart.modelo.Status;

public class TestarDao {

	public static void main(String[] args) throws SQLException {
		CreationFactory c = new CreationFactory();
		c.criarTabelas();

		Status status = new Status();
		status.setNome("Status eclipse");
		StatusDao dao = new StatusDao();
		dao.adiciona(status);

	}

}
