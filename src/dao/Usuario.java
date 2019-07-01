package dao;

public class Usuario {
	private Integer id;
	private String nome;
	private int idade;
	private String login;
	private String senha;
	private String email;
	private String sexo;

	public Usuario(String login, String senha){
		this.login = login;
		this.senha = senha;
	}

	public Usuario() {

	};



	public Integer getId() {
		return id;
	}
	public void setId(Integer idUsuario) {
		this.id = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String novoLogin) {
		this.login = novoLogin;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public int getIdade(){
		return idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


}
