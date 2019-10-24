package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class InserirProjeto {
	
	public InserirProjeto(String descricao, long codigo, String local, long departamento) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "insert into projeto(descricao, codigo, local, departamento) "
				+ "values (?, ?, ?, ?)";	
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,descricao);
			cmd.setInt(2,(int) codigo);
			cmd.setString(3,local);
			cmd.setInt(4,(int)departamento);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Projeto inserido com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(descricao).log(Level.SEVERE, null, ex);
		}
	}
}
