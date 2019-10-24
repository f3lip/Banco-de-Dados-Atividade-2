package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class AlterarLocal {
	
	public AlterarLocal(long departamento, String nome) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "update local set nome = ? where departamento = ?";
		
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,nome);
			cmd.setInt(2,(int) departamento);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Local alterado com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(nome).log(Level.SEVERE, null, ex);
		}
	}
}
