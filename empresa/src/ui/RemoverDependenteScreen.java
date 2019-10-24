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

import model.RemoverDependente;

public class RemoverDependenteScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel codigoLabel = new JLabel("Codigo do Empregado Associado ao Dependente: ");
	private JLabel nomeLabel = new JLabel("Nome do Dependente a ser Removido: ");

	// Cria uma caixa de texto
	private JTextField textBoxCodigo = new JTextField();
	private JTextField textBoxNome = new JTextField();
	

	// Cria um bot�o
	private JButton removerButton = new JButton("Remover");

	public RemoverDependenteScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(2,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(codigoLabel);
		leftSide.add(nomeLabel);
		center.add(textBoxCodigo);
		center.add(textBoxNome);
		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(removerButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Remover Dependente");
		this.removerButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		String codigo = textBoxCodigo.getText();
		String nome = textBoxNome.getText();
		textBoxCodigo.setText("");
		textBoxNome.setText("");
		RemoverDependente r;
		try {
			r = new RemoverDependente(codigo, nome);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
