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

import model.InserirDependente;

public class InserirDependenteScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel nomeLabel = new JLabel("Nome: ");
	private JLabel empregadoLabel = new JLabel("Codigo do Empregado: ");
	private JLabel dataNascimentoLabel = new JLabel("Data de Nascimento (formato DD/MM/YYYY): ");
	private JLabel sexoLabel = new JLabel("Sexo (M ou F): ");
	private JLabel parentescoLabel = new JLabel("Parentesco: ");
	
	// Cria uma caixa de texto
	private MaskFormatter ftmDate;
	private MaskFormatter ftmSex;
	private JTextField textBoxEmpregado = new JTextField();
	private JTextField textBoxNome = new JTextField();
	private JFormattedTextField textBoxSexo;
	private JFormattedTextField textBoxDataNascimento;
	private JTextField textBoxParentesco = new JTextField();

	// Cria um bot�o
	private JButton inserirButton = new JButton("Inserir");

	public InserirDependenteScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(5,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(empregadoLabel);
		leftSide.add(nomeLabel);
		leftSide.add(sexoLabel);
		leftSide.add(dataNascimentoLabel);
		leftSide.add(parentescoLabel);
		center.add(textBoxEmpregado);
		center.add(textBoxNome);
		ftmSex = new MaskFormatter("*");
		ftmSex.setValidCharacters("MFmf");
		textBoxSexo = new JFormattedTextField(ftmSex);
		center.add(textBoxSexo);
		ftmDate = new MaskFormatter("##/##/####");
		textBoxDataNascimento = new JFormattedTextField(ftmDate);
		center.add(textBoxDataNascimento);
		center.add(textBoxParentesco);
		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(inserirButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Inserir Dependente");
		this.inserirButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		String empregado = textBoxEmpregado.getText();
		String nome = textBoxNome.getText();
		String datanascimento = textBoxDataNascimento.getText();
		String sexo = textBoxSexo.getText();
		String parentesco = textBoxParentesco.getText();
		textBoxEmpregado.setText("");
		textBoxNome.setText("");
		textBoxDataNascimento.setText("");
		textBoxSexo.setText("");
		textBoxParentesco.setText("");
		InserirDependente i;
		try {
			i = new InserirDependente(empregado, nome, sexo, datanascimento, parentesco);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
