<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Fornecedor</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<!-- Inicio do formul�rio -->
	<form name="form" class="centralizado" action="adicionaFornecedor">
		<h5 class="centralizarTexto">Cadastrar Fornecedor</h5>
		<br />
		<!-- Nome -->
		<div class="input-field col s12">
			<input type="text" name="nome" required="required" class="validate">
			<label for="nome">Nome da Empresa</label> <br />
		</div>
		<!-- Endere�o -->
		<div class="input-field col s12">
			<input id="endereco" type="text" name="endereco" required="required"
				class="validate"> <label for="nome">Endere�o</label> <br />
		</div>


		<table>
			<tr>
				<!-- Telefone 1 -->
				<td><div class="input-field col s12">
						<input name="tel1" type="tel" pattern=".{15,}" class="validate"
							maxlength="15" onKeyPress="MascaraTelefone(form.tel1);">
						<label for="tel1">Celular</label> <br />
					</div></td>
				<!-- Telefone 2 -->
				<td>
					<div class="input-field col s12">
						<input name="tel2" type="tel" pattern=".{15,}" class="validate"
							maxlength="15" onKeyPress="MascaraTelefone(form.tel2);">
						<label for="tel2">Telefone</label> <br />
					</div>
				</td>
				<!-- Telefone 3 -->
				<td>
					<div class="input-field col s12">
						<input name="tel3" type="tel" pattern=".{15,}" class="validate"
							maxlength="15" onKeyPress="MascaraTelefone(form.tel3);">
						<label for="tel3">Telefone Comercial</label> <br />
					</div>

				</td>
			</tr>
		</table>

		<!-- CNPJ -->
		<div class="input-field col s12">
			<input name="cnpj" type="text" pattern=".{15,}" class="validate"
				maxlength="18" onKeyPress="MascaraCNPJ(form.cnpj);"> <label
				for="cnpj">CNPJ</label> <br />
		</div>
		<!-- Status -->
		<p>
			<input type="checkbox" id="status" /> <label for="status">Ativo</label>
		</p>
		<p>
		<div class="centralizarTexto">
			<input class="waves-effect waves-light btn" type="submit"
				value="Salvar" />
		</div>
	</form>

	<c:import url="rodape.jsp" />
</body>
</html>