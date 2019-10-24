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

import model.InserirDepartamento;

public class InserirDepartamentoScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel nomeLabel = new JLabel("Nome: ");
	private JLabel codigoLabel = new JLabel("Codigo: ");
	private JLabel gerenteLabel = new JLabel("Gerente: ");
	private JLabel inicioGerenteLabel = new JLabel("Data de Início (formato DD/MM/YYYY): ");
	
	// Cria uma caixa de texto
	private MaskFormatter ftmDate;
	NumberFormat longFormat = NumberFormat.getIntegerInstance();
	NumberFormatter numberFormatter = new NumberFormatter(longFormat);
	private JTextField textBoxNome = new JTextField();
	private JFormattedTextField textBoxCodigo;
	private JTextField textBoxGerente = new JTextField();
	private JFormattedTextField textBoxInicioGerente;

	// Cria um bot�o
	private JButton inserirButton = new JButton("Inserir");

	public InserirDepartamentoScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(4,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(nomeLabel);
		leftSide.add(codigoLabel);
		leftSide.add(gerenteLabel);
		leftSide.add(inicioGerenteLabel);
		center.add(textBoxNome);
		numberFormatter.setAllowsInvalid(false);
		textBoxCodigo = new JFormattedTextField(numberFormatter);
		center.add(textBoxCodigo);
		center.add(textBoxGerente);
		ftmDate = new MaskFormatter("##/##/####");
		textBoxInicioGerente = new JFormattedTextField(ftmDate);
		center.add(textBoxInicioGerente);

		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(inserirButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Inserir Departamento");
		this.inserirButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		String nome = textBoxNome.getText();
		long codigo = (long) textBoxCodigo.getValue();
		String gerente = textBoxGerente.getText();
		String iniciogerente = textBoxInicioGerente.getText();
		textBoxNome.setText("");
		textBoxCodigo.setText("");
		textBoxGerente.setText("");
		textBoxInicioGerente.setText("");
		InserirDepartamento i;
		try {
			i = new InserirDepartamento(nome, codigo, gerente, iniciogerente);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
