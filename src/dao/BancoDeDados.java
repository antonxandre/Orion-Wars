package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class BancoDeDados {
	public boolean acesso;
	public Usuario usuario = new Usuario();
	public String url = "jdbc:mysql://localhost/login?useTimezone=true&serverTimezone=UTC&useSSL=false";
	public String loginBD = "root";
	public String senhaBD = "";
	public Connection conexao;
	public PreparedStatement pesquisa;
	public ResultSet resultado;

	public Usuario acessarBD(String login, String senha) {
		try {
			conexao = DriverManager.getConnection(url, loginBD, senhaBD);
			pesquisa = conexao.prepareStatement("select login, senha, nome, email, sexo from tbl_usuario where login='" + login + "'and senha='" + senha + "'");

			resultado = pesquisa.executeQuery();

			while(resultado.next() ) {
				usuario.setLogin(resultado.getString("login"));

				usuario.setNome(resultado.getString("nome"));

				usuario.setEmail(resultado.getString("email"));
				usuario.setSexo(resultado.getString("sexo"));
				acesso = true;
			}

			if(acesso==false) {
				JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
			}	 
		}catch (Exception erro) {

			erro.printStackTrace();
		}

		return usuario;

	}

	public String getUsuarioNome() {
		return usuario.getNome();
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

}
