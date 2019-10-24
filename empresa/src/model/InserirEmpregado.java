package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

public class InserirEmpregado {
	
	public InserirEmpregado(String nome, String nomedomeio, String sobrenome, String codigo, String dtnascimento, String endereco, String sexo, long salario, String gerente, String departamento) throws Exception {
		Connection conexao = DataBase.createConnection();
		String sql = "insert into empregado(nome, nomedomeio, sobrenome, codigo, dtnascimento, endereco, sexo, salario, gerente, departamento) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date utildate = df.parse(dtnascimento);
		java.sql.Date date = new java.sql.Date(utildate.getTime());  
		
		
		PreparedStatement cmd;
		try{
			cmd = conexao.prepareStatement(sql);
			cmd.setString(1,nome);
			cmd.setString(2,nomedomeio);
			cmd.setString(3,sobrenome);
			cmd.setString(4,codigo);
			cmd.setDate(5,date);
			cmd.setString(6,endereco);
			cmd.setString(7,sexo);
			cmd.setInt(8,(int) salario);
			cmd.setString(9,gerente);
			cmd.setInt(10,Integer.parseInt(departamento));

			
			cmd.execute();
			
			cmd.close();
			
			JOptionPane.showMessageDialog(null, "Empregado inserido com sucesso!");
		} catch(SQLException ex) {
			Logger.getLogger(nome).log(Level.SEVERE, null, ex);
		}
	}
}
