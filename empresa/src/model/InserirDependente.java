package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class InserirDependente {
	
	public InserirDependente(String empregado, String nome, String sexo, String dtnascimento, String parentesco) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "insert into dependente(empregado, nome, sexo, dtnascimento, parentesco) "
				+ "values (?, ?, ?, ?, ?)";
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date utildate = df.parse(dtnascimento);
		java.sql.Date date = new java.sql.Date(utildate.getTime());  
		
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,empregado);
			cmd.setString(2,nome);
			cmd.setString(3,sexo);
			cmd.setDate(4,date);
			cmd.setString(5,parentesco);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Dependente inserido com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(nome).log(Level.SEVERE, null, ex);
		}
	}
}
