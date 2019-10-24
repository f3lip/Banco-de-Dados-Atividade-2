package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import model.AlterarProjeto;

public class AlterarProjetoScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel descricaoLabel = new JLabel("Nova Descrição: ");
	private JLabel codigoLabel = new JLabel("Codigo: ");
	private JLabel localLabel = new JLabel("Novo Local: ");
	private JLabel departamentoLabel = new JLabel("Novo Departamento: ");
	
	// Cria uma caixa de texto
	NumberFormat longFormat = NumberFormat.getIntegerInstance();
	NumberFormatter numberFormatter = new NumberFormatter(longFormat);
	private JTextField textBoxDescricao = new JTextField();
	private JFormattedTextField textBoxCodigo;
	private JTextField textBoxLocal = new JTextField();
	private JFormattedTextField textBoxDepartamento;

	// Cria um bot�o
	private JButton alterarButton = new JButton("Alterar");

	public AlterarProjetoScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(4,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(codigoLabel);
		leftSide.add(descricaoLabel);
		leftSide.add(localLabel);
		leftSide.add(departamentoLabel);
		numberFormatter.setAllowsInvalid(false);
		textBoxCodigo = new JFormattedTextField(numberFormatter);
		center.add(textBoxCodigo);
		center.add(textBoxDescricao);
		center.add(textBoxLocal);
		textBoxDepartamento = new JFormattedTextField(numberFormatter);
		center.add(textBoxDepartamento);

		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(alterarButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Alterar Projeto");
		this.alterarButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		String descricao = textBoxDescricao.getText();
		long codigo = (long) textBoxCodigo.getValue();
		String local = textBoxLocal.getText();
		long departamento = (long) textBoxDepartamento.getValue();
		textBoxDescricao.setText("");
		textBoxCodigo.setText("");
		textBoxLocal.setText("");
		textBoxDepartamento.setText("");
		AlterarProjeto a;
		try {
			a = new AlterarProjeto(descricao, codigo, local, departamento);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
