package br.com.cotasmart.modelo;

public class Fornecedor {

	private int codFornecedor;
	private String nome;
	private String endereco;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String cnpj;

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Fornecedor outroFornecedor = (Fornecedor) obj;

		return this.cnpj == outroFornecedor.cnpj;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(Integer codFornecedor){
		this.codFornecedor = codFornecedor;
		}
}
