<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ page
		import="java.util.*,
br.com.cotasmart.dao.*,
br.com.cotasmart.modelo.*"%>

  <table>
		<%
			FornecedorDao dao = new FornecedorDao();
			List<Fornecedor> fornecedores = dao.getLista();
			for (Fornecedor fornecedor : fornecedores) {
		%>
		<tr>
			<td><%=fornecedor.getCodFornecedor()%></td>
			<td><%=fornecedor.getNome()%></td>
			<td><%=fornecedor.getCnpj()%></td>
			<td><%=fornecedor.getEndereco()%></td>
			<td><%=fornecedor.getTelefone1()%></td>
			<td><%=fornecedor.getTelefone2()%></td>
			<td><%=fornecedor.getTelefone3()%></td>
		</tr>
		<%
			}
		%>
	</table>





</body>
</html>