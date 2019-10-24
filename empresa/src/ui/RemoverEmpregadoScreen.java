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

import model.RemoverEmpregado;

public class RemoverEmpregadoScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel codigoLabel = new JLabel("Codigo do Empregado a ser Removido: ");

	// Cria uma caixa de texto
	private JTextField textBoxCodigo = new JTextField();
	

	// Cria um bot�o
	private JButton removerButton = new JButton("Remover");

	public RemoverEmpregadoScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(1,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(codigoLabel);
		center.add(textBoxCodigo);
		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(removerButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Remover Empregado");
		this.removerButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		String codigo = textBoxCodigo.getText();
		textBoxCodigo.setText("");
		RemoverEmpregado r;
		try {
			r = new RemoverEmpregado(codigo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
