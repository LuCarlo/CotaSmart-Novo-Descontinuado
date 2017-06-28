package br.com.cotasmart.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cotasmart.dao.FornecedorDao;
import br.com.cotasmart.modelo.Fornecedor;

@SuppressWarnings("serial")
@WebServlet("/AdicionaFornecedor")
public class AdicionaFornecedorServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String nomeFornecedor = request.getParameter("nomeFornecedor");
		String endereco = request.getParameter("endereco");
		String telefone1 = request.getParameter("telefone1");
		String telefone2 = request.getParameter("telefone2");
		String telefone3 = request.getParameter("telefone3");
		String cnpj = request.getParameter("cnjp");

		Fornecedor fornecedor = new Fornecedor(cnpj, telefone1, nomeFornecedor);

		fornecedor.setEndereco(endereco);
		fornecedor.setTelefone2(telefone2);
		fornecedor.setTelefone3(telefone3);

		FornecedorDao dao = new FornecedorDao();

		if (!dao.verificaSeExiste(fornecedor.getCnpj())) {
			dao.adiciona(fornecedor);
			out.println("<html><body><h1>");
			out.println("Empresa: " + fornecedor.getNomeFornecedor() + " adicionado com sucesso");
			out.println("</h1></body></html>");	
		}else{
			System.out.println("Fornecedor já cadastrado");
		}

		
	}

}
