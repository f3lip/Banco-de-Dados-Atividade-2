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

import model.InserirEmpregado;

public class InserirEmpregadoScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel nomeLabel = new JLabel("Nome: ");
	private JLabel nomeDoMeioLabel = new JLabel("Nome do Meio: ");
	private JLabel sobrenomeLabel = new JLabel("Sobrenome: ");
	private JLabel codigoLabel = new JLabel("Codigo: ");
	private JLabel dataNascimentoLabel = new JLabel("Data de Nascimento (formato DD/MM/YYYY): ");
	private JLabel enderecoLabel = new JLabel("Endereço: ");
	private JLabel sexoLabel = new JLabel("Sexo (M ou F): ");
	private JLabel salarioLabel = new JLabel("Salario: ");
	private JLabel gerenteLabel = new JLabel("Codigo do Gerente: ");
	private JLabel departamentoLabel = new JLabel("Codigo do Departamento: ");

	// Cria uma caixa de texto
	private MaskFormatter ftmDate;
	private MaskFormatter ftmSex;
	private MaskFormatter ftmNomeDoMeio;
	NumberFormat longFormat = NumberFormat.getIntegerInstance();
	NumberFormatter numberFormatter = new NumberFormatter(longFormat);
	private JTextField textBoxNome = new JTextField();
	private JFormattedTextField textBoxNomeDoMeio;
	private JTextField textBoxSobrenome = new JTextField();
	private JTextField textBoxCodigo = new JTextField();
	private JFormattedTextField textBoxDataNascimento;
	private JTextField textBoxEndereco = new JTextField();
	private JFormattedTextField textBoxSexo;
	private JFormattedTextField textBoxSalario;
	private JTextField textBoxGerente = new JTextField();
	private JFormattedTextField textBoxDepartamento;
	

	// Cria um bot�o
	private JButton inserirButton = new JButton("Inserir");

	public InserirEmpregadoScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(10,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(10,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(nomeLabel);
		leftSide.add(nomeDoMeioLabel);
		leftSide.add(sobrenomeLabel);
		leftSide.add(codigoLabel);
		leftSide.add(dataNascimentoLabel);
		leftSide.add(enderecoLabel);
		leftSide.add(sexoLabel);
		leftSide.add(salarioLabel);
		leftSide.add(gerenteLabel);
		leftSide.add(departamentoLabel);
		center.add(textBoxNome);
		ftmNomeDoMeio = new MaskFormatter("*");
		ftmNomeDoMeio.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		textBoxNomeDoMeio = new JFormattedTextField(ftmNomeDoMeio);
		center.add(textBoxNomeDoMeio);
		center.add(textBoxSobrenome);
		center.add(textBoxCodigo);
		ftmDate = new MaskFormatter("##/##/####");
		textBoxDataNascimento = new JFormattedTextField(ftmDate);
		center.add(textBoxDataNascimento);
		center.add(textBoxEndereco);
		ftmSex = new MaskFormatter("*");
		ftmSex.setValidCharacters("MFmf");
		textBoxSexo = new JFormattedTextField(ftmSex);
		center.add(textBoxSexo);
		numberFormatter.setAllowsInvalid(false);
		textBoxSalario = new JFormattedTextField(numberFormatter);
		center.add(textBoxSalario);
		center.add(textBoxGerente);
		textBoxDepartamento = new JFormattedTextField(numberFormatter);
		center.add(textBoxDepartamento);
		
		
		// Adiciona conteudo ao frame
		this.add(leftSide, BorderLayout.WEST);
		this.add(center, BorderLayout.CENTER);
		this.add(inserirButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Inserir Empregado");
		this.inserirButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Acao a ser executada quando o botao for clicado
		String nome = textBoxNome.getText();
		String nomedomeio = textBoxNomeDoMeio.getText();
		String sobrenome = textBoxSobrenome.getText();
		String codigo = textBoxCodigo.getText();
		String datanascimento = textBoxDataNascimento.getText();
		String endereco = textBoxEndereco.getText();
		String sexo = textBoxSexo.getText();
		long salario = (long) textBoxSalario.getValue();
		String gerente = textBoxGerente.getText();
		String departamento = textBoxDepartamento.getText();
		textBoxNome.setText("");
		textBoxNomeDoMeio.setText("");
		textBoxSobrenome.setText("");
		textBoxCodigo.setText("");
		textBoxDataNascimento.setText("");
		textBoxEndereco.setText("");
		textBoxSexo.setText("");
		textBoxSalario.setText("");
		textBoxGerente.setText("");
		textBoxDepartamento.setText("");
		InserirEmpregado i;
		try {
			i = new InserirEmpregado(nome, nomedomeio, sobrenome, codigo, datanascimento, endereco, sexo, salario, gerente, departamento);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
