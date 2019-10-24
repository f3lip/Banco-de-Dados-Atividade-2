package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class AlterarDepartamento {
	
	public AlterarDepartamento(String nome, long codigo, String gerente, String iniciogerente) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "update departamento set nome = ?, gerente = ?, iniciogerente = ? where codigo = ?";
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date utildate = df.parse(iniciogerente);
		java.sql.Date date = new java.sql.Date(utildate.getTime());  
		
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,nome);
			cmd.setString(2,gerente);
			cmd.setDate(3,date);
			cmd.setInt(4,(int) codigo);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Departamento alterado com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(nome).log(Level.SEVERE, null, ex);
		}
	}
}
