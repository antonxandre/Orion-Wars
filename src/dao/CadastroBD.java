package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CadastroBD {

	boolean usuarioCadastrado = false;
	static int resultado;
	public void cadastrarUsuario (String login, String senha, String nome, String email, char sexo){


		// ip da máquina
		String url = "jdbc:mysql://localhost:3306/login?useTimezone=true&serverTimezone=UTC&useSSL=false";
		String inserir ="use login;insert into tbl_usuario (login, senha, nome , email, sexo) values ("+"'"+login+"', " +"'"+senha+ "', " +"'" +nome +"', '"+ email +"', '"+sexo+"')";
		try {
			Connection conexao = DriverManager.getConnection(url, "root", "vertrigo");
			PreparedStatement pesquisa = conexao.prepareStatement(inserir);
			resultado = pesquisa.executeUpdate("insert into tbl_usuario (login, senha, nome, email, sexo) values ("+"'"+login+"', " +"'"+senha+ "', " +"'" +nome +"', '"+ email +"', '"+sexo+"')");



		}catch(Exception erro){
			erro.printStackTrace();
		}


	}
	public int getCadastrado(){
		return resultado;
	}


}
