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

import model.AlterarEmpregado;

public class AlterarEmpregadoScreen extends JInternalFrame implements ActionListener{
	// Cria uma label
	private JLabel codigoLabel = new JLabel("Codigo do Empregado: ");
	private JLabel nomeLabel = new JLabel("Novo Nome: ");
	private JLabel nomeDoMeioLabel = new JLabel("Novo Nome do Meio: ");
	private JLabel sobrenomeLabel = new JLabel("Novo Sobrenome: ");
	private JLabel dataNascimentoLabel = new JLabel("Nova Data de Nascimento (formato DD/MM/YYYY): ");
	private JLabel enderecoLabel = new JLabel("Novo Endereço: ");
	private JLabel sexoLabel = new JLabel("Novo Sexo (M ou F): ");
	private JLabel salarioLabel = new JLabel("Novo Salario: ");
	private JLabel gerenteLabel = new JLabel("Novo Codigo do Gerente: ");
	private JLabel departamentoLabel = new JLabel("Novo Codigo do Departamento: ");

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
	private JButton alterarButton = new JButton("Alterar");

	public AlterarEmpregadoScreen() throws Exception {
		/*
		 * Interface
		 */
		
		// Cria paineis
		JPanel leftSide = new JPanel();
		leftSide.setLayout(new GridLayout(10,1));
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(10,1));
		
		//Adiciona conteudo aos paineis
		leftSide.add(codigoLabel);
		leftSide.add(nomeLabel);
		leftSide.add(nomeDoMeioLabel);
		leftSide.add(sobrenomeLabel);
		leftSide.add(dataNascimentoLabel);
		leftSide.add(enderecoLabel);
		leftSide.add(sexoLabel);
		leftSide.add(salarioLabel);
		leftSide.add(gerenteLabel);
		leftSide.add(departamentoLabel);
		center.add(textBoxCodigo);
		center.add(textBoxNome);
		ftmNomeDoMeio = new MaskFormatter("*");
		ftmNomeDoMeio.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		textBoxNomeDoMeio = new JFormattedTextField(ftmNomeDoMeio);
		center.add(textBoxNomeDoMeio);
		center.add(textBoxSobrenome);
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
		this.add(alterarButton, BorderLayout.EAST);
		
		// Configura o frame
		this.setSize(700,500);
		this.setTitle("Alterar Empregado");
		this.alterarButton.addActionListener(this);
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
		AlterarEmpregado i;
		try {
			i = new AlterarEmpregado(nome, nomedomeio, sobrenome, codigo, datanascimento, endereco, sexo, salario, gerente, departamento);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
