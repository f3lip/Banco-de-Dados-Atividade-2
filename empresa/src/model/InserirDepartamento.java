package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class InserirDepartamento {
	
	public InserirDepartamento(String nome, long codigo, String gerente, String iniciogerente) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "insert into departamento(nome, codigo, gerente, iniciogerente) "
				+ "values (?, ?, ?, ?)";
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date utildate = df.parse(iniciogerente);
		java.sql.Date date = new java.sql.Date(utildate.getTime());  
		
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,nome);
			cmd.setInt(2,(int) codigo);
			cmd.setString(3,gerente);
			cmd.setDate(4,date);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Departamento inserido com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(nome).log(Level.SEVERE, null, ex);
		}
	}
}
