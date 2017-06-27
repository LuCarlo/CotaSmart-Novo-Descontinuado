package br.com.cotasmart.modelo;

public class Usuario {
	private Long codUsuario;
	private String nome;
	private String login;
	private String senha;
	private Integer codStatus;
	private Integer codGrupo;
	
	public Usuario(String nome, String login, String senha, Integer codStatus, Integer codGrupo) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.codStatus = codStatus;
		this.codGrupo = codGrupo;
	}

	public Long getCodUsuario() {
		return codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(Integer codStatus) {
		this.codStatus = codStatus;
	}

	public Integer getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(Integer codGrupo) {
		this.codGrupo = codGrupo;
	}

}
