package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class RemoverLocal {
	public RemoverLocal(long departamento, String nome) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "delete from local where departamento = ? and nome = ?";
		
		PreparedStatement stmt;
		try{
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,(int) departamento);
			stmt.setString(2,nome);
			stmt.execute();
			stmt.close();
			conexao.close();
			JOptionPane.showMessageDialog(null, "Removido com sucesso");
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
}
