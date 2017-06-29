package br.com.cotasmart.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cotasmart.dao.StatusDao;
import br.com.cotasmart.modelo.Status;

@SuppressWarnings("serial")
@WebServlet("/adicionaStatus")
public class AdicionaStatusServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nome = "testão";//request.getParameter("nome");
		Status status = new Status();
		status.setNome(nome);

		StatusDao dao = new StatusDao();
		dao.adiciona(status);

		
		out.println("<html><body><h1>");
		out.println("Usuário: " + status.getNome() + " adicionado com sucesso");
		out.println("</h1></body></html>");
	}

}
