package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class AlterarEmpregado {
	public AlterarEmpregado(String nome, String nomedomeio, String sobrenome, String codigo, String dtnascimento, String endereco, String sexo, long salario, String gerente, String departamento) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "UPDATE empregado set nome =?, nomedomeio =?, sobrenome =?, dtnascimento =?, endereco =?, sexo =?, salario =?, gerente =?, departamento =? where codigo =?";
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date utildate = df.parse(dtnascimento);
		java.sql.Date date = new java.sql.Date(utildate.getTime());  
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		try{
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1,nome);
			stmt.setString(2,nomedomeio);
			stmt.setString(3,sobrenome);
			stmt.setDate(4,date);
			stmt.setString(5,endereco);
			stmt.setString(6,sexo);
			stmt.setInt(7,(int) salario);
			stmt.setString(8,gerente);
			stmt.setInt(9,Integer.parseInt(departamento));
			stmt.setString(10,codigo);
			stmt.execute();
			stmt.close();
			conexao.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
		} catch (SQLException ex){
			ex.printStackTrace();
		}
	}
}
