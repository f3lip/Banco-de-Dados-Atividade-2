package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class RemoverDepartamento {
	public RemoverDepartamento(long codigo) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "delete from departamento where codigo =?";
		String removelocal = "delete from local where departamento = ?";
		
		PreparedStatement stmt;
		try{
			stmt = conexao.prepareStatement(removelocal);
			stmt.setInt(1,(int) codigo);
			stmt.execute();
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,(int) codigo);
			stmt.execute();
			stmt.close();
			conexao.close();
			JOptionPane.showMessageDialog(null, "Removido com sucesso");
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
}
