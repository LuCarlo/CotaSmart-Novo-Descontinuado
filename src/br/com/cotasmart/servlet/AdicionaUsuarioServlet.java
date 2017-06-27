package br.com.cotasmart.servlet;
 
 import java.io.IOException;
 import java.io.PrintWriter;
 
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 import br.com.cotasmart.dao.UsuarioDao;
 import br.com.cotasmart.modelo.Usuario;
 
 @SuppressWarnings("serial")
 @WebServlet("/adicionaUsuario")
 public class AdicionaUsuarioServlet extends HttpServlet {
 	@Override
 	protected void service(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		PrintWriter out = response.getWriter();
 
 		String nome = request.getParameter("nome");
 		String login = request.getParameter("login");
 		String senha = request.getParameter("senha");
 		String codStatusString = request.getParameter("codStatus");
 		String codGrupoString = request.getParameter("codGrupo");
 
 		Integer codStatus = Integer.parseInt(codStatusString);
 		Integer codGrupo = Integer.parseInt(codGrupoString);
 
 		Usuario usuario = new Usuario();
 		usuario.setNome(nome);
 		usuario.setLogin(login);
 		usuario.setSenha(senha);
 		usuario.setCodGrupo(codGrupo);
 		usuario.setCodStatus(codStatus);
 
 		UsuarioDao dao = new UsuarioDao();
 
 		dao.adiciona(usuario);
 		
 		out.println("<html><body><h1>");
 		out.println("Usuário: "+usuario.getNome()+" adicionado com sucesso");
 		out.println("</h1></body></html>");
 
 	}
 
 }