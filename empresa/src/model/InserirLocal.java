package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class InserirLocal {
	
	public InserirLocal(long departamento, String nome) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "insert into local(departamento, nome) "
				+ "values (?, ?)";
		
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setInt(1,(int) departamento);
			cmd.setString(2,nome);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Local inserido com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(nome).log(Level.SEVERE, null, ex);
		}
	}
}
