package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public static Connection createConnection(){	
		String stringDeConexao = "jdbc:postgresql://localhost:5432/empresa";
		String usuario = "postgres";
		String senha = "postgres";
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}
