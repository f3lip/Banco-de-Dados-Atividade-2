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

import model.AlterarLocal;

public class AlterarLocalScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel departamentoLabel = new JLabel("Departamento: ");
	private JLabel nomeLabel = new JLabel("Novo Nome: ");
	
	// Cria uma caixa de texto
	NumberFormat longFormat = NumberFormat.getIntegerInstance();
	NumberFormatter numberFormatter = new NumberFormatter(longFormat);
	private JTextField textBoxNome = new JTextField();
	private JFormattedTextField textBoxDepartamento = new JFormattedTextField();
	// Cria um bot�o
	private JButton alterarButton = new JButton("Alterar");

	public AlterarLocalScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(2,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(departamentoLabel);
		leftSide.add(nomeLabel);
		numberFormatter.setAllowsInvalid(false);
		textBoxDepartamento = new JFormattedTextField(numberFormatter);
		center.add(textBoxDepartamento);
		center.add(textBoxNome);
		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(alterarButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Inserir Local");
		this.alterarButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		String nome = textBoxNome.getText();
		long departamento = (long) textBoxDepartamento.getValue();
		textBoxNome.setText("");
		textBoxDepartamento.setText("");
		AlterarLocal a;
		try {
			a = new AlterarLocal(departamento, nome);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
