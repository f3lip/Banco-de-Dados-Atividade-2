package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class AlterarDependente {
	
	public AlterarDependente(String empregado, String nome, String sexo, String dtnascimento, String parentesco) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "update dependente set sexo = ?, dtnascimento = ?, parentesco = ? where empregado = ? and nome = ?";
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date utildate = df.parse(dtnascimento);
		java.sql.Date date = new java.sql.Date(utildate.getTime());  
		
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,sexo);
			cmd.setDate(2,date);
			cmd.setString(3,parentesco);
			cmd.setString(4,empregado);
			cmd.setString(5,nome);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Dependente alterado com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(nome).log(Level.SEVERE, null, ex);
		}
	}
}
