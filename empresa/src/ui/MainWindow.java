package ui;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class MainWindow extends JFrame implements ActionListener {

	// Cria a tela de trabalho
	public static JDesktopPane screen = new JDesktopPane();

	// Definindo botoes
	public static JButton buttonInserirEmpregado = new JButton("Inserir Empregado");
	public static JButton buttonInserirDependente = new JButton("Inserir Dependente");
	public static JButton buttonInserirDepartamento = new JButton("Inserir Departamento");
	public static JButton buttonInserirLocal = new JButton("Inserir Local");
	public static JButton buttonInserirProjeto = new JButton("Inserir Projeto");
	public static JButton buttonAlterarEmpregado = new JButton("Alterar Empregado");
	public static JButton buttonAlterarDependente = new JButton("Alterar Dependente");
	public static JButton buttonAlterarDepartamento = new JButton("Alterar Departamento");
	public static JButton buttonAlterarLocal = new JButton("Alterar Local");
	public static JButton buttonAlterarProjeto = new JButton("Alterar Projeto");
	public static JButton buttonRemoverEmpregado = new JButton("Remover Empregado");
	public static JButton buttonRemoverDependente = new JButton("Remover Dependente");
	public static JButton buttonRemoverDepartamento = new JButton("Remover Departamento");
	public static JButton buttonRemoverLocal = new JButton("Remover Local");
	public static JButton buttonRemoverProjeto = new JButton("Remover Projeto");

	public MainWindow() {
		// Definindo containers
		Container c1 = this.getContentPane();
		c1.setLayout(new BorderLayout());
		Container c2 = this.getContentPane();
		c2.setLayout(new BorderLayout());

		// Configurando botoes
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(5, 3));
		buttons.add(buttonInserirEmpregado);
		buttons.add(buttonAlterarEmpregado);
		buttons.add(buttonRemoverEmpregado);
		buttons.add(buttonInserirDependente);
		buttons.add(buttonAlterarDependente);
		buttons.add(buttonRemoverDependente);
		buttons.add(buttonInserirDepartamento);
		buttons.add(buttonAlterarDepartamento);
		buttons.add(buttonRemoverDepartamento);
		buttons.add(buttonInserirLocal);
		buttons.add(buttonAlterarLocal);
		buttons.add(buttonRemoverLocal);
		buttons.add(buttonInserirProjeto);
		buttons.add(buttonAlterarProjeto);
		buttons.add(buttonRemoverProjeto);
		
		JPanel side = new JPanel();
		side.add(buttons);
		
		c1.add(BorderLayout.WEST, side);
		c2.add(BorderLayout.CENTER, screen);

		// Configura a janela
		this.setSize(1600, 900);
		this.setResizable(false);
		this.setTitle("Gerenciar Banco de Dados");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonInserirEmpregado.addActionListener(this);
		buttonInserirDependente.addActionListener(this);
		buttonInserirDepartamento.addActionListener(this);
		buttonInserirLocal.addActionListener(this);
		buttonInserirProjeto.addActionListener(this);
		buttonAlterarEmpregado.addActionListener(this);
		buttonAlterarDependente.addActionListener(this);
		buttonAlterarDepartamento.addActionListener(this);
		buttonAlterarLocal.addActionListener(this);
		buttonAlterarProjeto.addActionListener(this);
		buttonRemoverEmpregado.addActionListener(this);
		buttonRemoverDependente.addActionListener(this);
		buttonRemoverDepartamento.addActionListener(this);
		buttonRemoverLocal.addActionListener(this);
		buttonRemoverProjeto.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Ações a serem executadas quando os botões são clicados
		if (e.getSource() == buttonInserirEmpregado) {
			screenClear();
			InserirEmpregadoScreen inserir;
			try {
				inserir = new InserirEmpregadoScreen();
				inserir.setVisible(true);
				screen.add(inserir);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonInserirDependente) {
			screenClear();
			InserirDependenteScreen inserir;
			try {
				inserir = new InserirDependenteScreen();
				inserir.setVisible(true);
				screen.add(inserir);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonInserirDepartamento) {
			screenClear();
			InserirDepartamentoScreen inserir;
			try {
				inserir = new InserirDepartamentoScreen();
				inserir.setVisible(true);
				screen.add(inserir);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonInserirLocal) {
			screenClear();
			InserirLocalScreen inserir;
			try {
				inserir = new InserirLocalScreen();
				inserir.setVisible(true);
				screen.add(inserir);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonInserirProjeto) {
			screenClear();
			InserirProjetoScreen inserir;
			try {
				inserir = new InserirProjetoScreen();
				inserir.setVisible(true);
				screen.add(inserir);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonAlterarEmpregado) {
			screenClear();
			AlterarEmpregadoScreen alterar;
			try {
				alterar = new AlterarEmpregadoScreen();
				alterar.setVisible(true);
				screen.add(alterar);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonAlterarDependente) {
			screenClear();
			AlterarDependenteScreen alterar;
			try {
				alterar = new AlterarDependenteScreen();
				alterar.setVisible(true);
				screen.add(alterar);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonAlterarDepartamento) {
			screenClear();
			AlterarDepartamentoScreen alterar;
			try {
				alterar = new AlterarDepartamentoScreen();
				alterar.setVisible(true);
				screen.add(alterar);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonAlterarLocal) {
			screenClear();
			AlterarLocalScreen alterar;
			try {
				alterar = new AlterarLocalScreen();
				alterar.setVisible(true);
				screen.add(alterar);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonAlterarProjeto) {
			screenClear();
			AlterarProjetoScreen alterar;
			try {
				alterar = new AlterarProjetoScreen();
				alterar.setVisible(true);
				screen.add(alterar);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonRemoverEmpregado) {
			screenClear();
			RemoverEmpregadoScreen remover;
			try {
				remover = new RemoverEmpregadoScreen();
				remover.setVisible(true);
				screen.add(remover);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonRemoverDependente) {
			screenClear();
			RemoverDependenteScreen remover;
			try {
				remover = new RemoverDependenteScreen();
				remover.setVisible(true);
				screen.add(remover);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonRemoverDepartamento) {
			screenClear();
			RemoverDepartamentoScreen remover;
			try {
				remover = new RemoverDepartamentoScreen();
				remover.setVisible(true);
				screen.add(remover);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonRemoverLocal) {
			screenClear();
			RemoverLocalScreen remover;
			try {
				remover = new RemoverLocalScreen();
				remover.setVisible(true);
				screen.add(remover);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == buttonRemoverProjeto) {
			screenClear();
			RemoverProjetoScreen remover;
			try {
				remover = new RemoverProjetoScreen();
				remover.setVisible(true);
				screen.add(remover);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// Limpa a tela
	private void screenClear() {
		screen.removeAll();
		screen.revalidate();
		screen.repaint();
	}

	public static void main(String[] args) {
		MainWindow main = new MainWindow();
		main.setVisible(true);
	}
}