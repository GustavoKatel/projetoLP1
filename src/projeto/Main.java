package projeto;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;

import projeto.controller.CurriculoController;
import projeto.view.JConsulta;
import projeto.view.JCurriculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Arthur, Gustavo, C.Marcelo, Rodolfo.
 *
 */
public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurriculoController controller = new CurriculoController();
					controller.load();
					//
					Main frame = new Main();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CurriculoController controller = new CurriculoController();
				controller.save();
			}
		});
		setBounds(100, 100, 691, 473);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		menuBar.add(mnArquivo);
		
		JMenuItem mntmNovoCurrculo = new JMenuItem("Novo Curr\u00EDculo");
		mntmNovoCurrculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNovoCurrculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCurriculo jcur = new JCurriculo();
				Main.this.desktopPane.add(jcur);
				jcur.setClosable(true);
				jcur.setVisible(true);
				jcur.setMaximizable(false);
				try {
					jcur.setMaximum(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		});
		mnArquivo.add(mntmNovoCurrculo);
		
		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JConsulta jcon = new JConsulta();
				Main.this.desktopPane.add(jcon);
				jcon.setClosable(true);
				jcon.setVisible(true);
				jcon.setMaximizable(false);
				try {
					jcon.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnArquivo.add(mntmPesquisar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setMnemonic('J');
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCadastroDeCurrculos = new JLabel("Cadastro de Curriculos");
		lblCadastroDeCurrculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCurrculos.setFont(new Font("Modern No. 20", Font.PLAIN, 29));
		lblCadastroDeCurrculos.setBounds(224, 187, 414, 32);
		desktopPane.add(lblCadastroDeCurrculos);
	}
}
