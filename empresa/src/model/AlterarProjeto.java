package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class AlterarProjeto {
	
	public AlterarProjeto(String descricao, long codigo, String local, long departamento) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "update projeto set descricao = ?, local = ?, departamento = ? where codigo = ?";	
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,descricao);
			cmd.setString(2,local);
			cmd.setInt(3,(int)departamento);
			cmd.setInt(4,(int) codigo);

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Projeto alterado com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(descricao).log(Level.SEVERE, null, ex);
		}
	}
}
