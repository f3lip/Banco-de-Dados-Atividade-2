package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class RemoverEmpregado {
	public RemoverEmpregado(String codigo) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "delete from empregado where codigo =?";
		String updateempregado = "update empregado set gerente = null where gerente = ?";
		String updatedepartamento = "update departamento set gerente = null where gerente = ?";
		String deletedependente = "delete from dependente where empregado = ?";
		
		PreparedStatement stmt;
		try{
			stmt = conexao.prepareStatement(deletedependente);
			stmt.setString(1,codigo);
			stmt.execute();
			stmt = conexao.prepareStatement(updatedepartamento);
			stmt.setString(1,codigo);
			stmt.execute();
			stmt = conexao.prepareStatement(updateempregado);
			stmt.setString(1,codigo);
			stmt.execute();
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1,codigo);
			stmt.execute();
			stmt.close();
			conexao.close();
			JOptionPane.showMessageDialog(null, "Removido com sucesso");
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
}
