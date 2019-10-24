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

import model.RemoverLocal;

public class RemoverLocalScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel codigoLabel = new JLabel("Codigo do Departamento Associado: ");
	private JLabel nomeLabel = new JLabel("Nome do Local a ser Removido: ");

	// Cria uma caixa de texto
	private JFormattedTextField textBoxCodigo;
	NumberFormat longFormat = NumberFormat.getIntegerInstance();
	NumberFormatter numberFormatter = new NumberFormatter(longFormat);
	private JTextField textBoxNome = new JTextField();
	

	// Cria um bot�o
	private JButton removerButton = new JButton("Remover");

	public RemoverLocalScreen() throws Exception {
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
		numberFormatter.setAllowsInvalid(false);
		textBoxCodigo = new JFormattedTextField(numberFormatter);
		center.add(textBoxCodigo);
		center.add(textBoxNome);
		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(removerButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Remover Local");
		this.removerButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		long codigo = (long) textBoxCodigo.getValue();
		String nome = textBoxNome.getText();
		textBoxCodigo.setText("");
		textBoxNome.setText("");
		RemoverLocal r;
		try {
			r = new RemoverLocal(codigo, nome);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
