package projeto.view;

import javax.swing.JInternalFrame;

import projeto.controller.CurriculoController;
import projeto.models.Curriculo;
import projeto.models.ExpDocente;
import projeto.models.ExpRelevante;
import projeto.models.Publicacao;
import projeto.models.Titulo;
import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.BoxLayout;

public class JCurriculo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private Curriculo curriculo;
	private CurriculoController controller;
	private JTextField nome_text;
	private JTextField endereco_text;
	private JFormattedTextField telefone_forText;
	private JTextField email_text;
	private JTextField cpf_text;
	private JTextField regProfissional_text;
	//
	private JPanel titulos_panel;
	private ButtonGroup TitulosGroup;
	//
	private JPanel expDocente_panel;
	private ButtonGroup expDocenteGroup;
	//
	private JPanel expRelevante_panel;
	private ButtonGroup expRelevanteGroup;
	//
	private JPanel publicacoes_panel;
	private ButtonGroup publicacoesGroup;
	//
	private boolean novo=true;
	
	public JCurriculo()
	{
		controller = new CurriculoController();
		this.curriculo = new Curriculo("", "", "", "", "", "");
		novo=true;
		initComponents();
	}
	
	public JCurriculo(Curriculo curriculo)
	{
		controller = new CurriculoController();
		this.curriculo = curriculo;
		novo=false;
		initComponents();
		preenche();
	}
	
	public void preenche()
	{
		if(curriculo!=null)
		{
			nome_text.setText(curriculo.getNome());
			endereco_text.setText(curriculo.getEndereco());
			telefone_forText.setText(curriculo.getTelefone());
			email_text.setText(curriculo.getEmail());
			cpf_text.setText(curriculo.getCpf());
			regProfissional_text.setText(curriculo.getReg_profissional());
		}
		preencheTitulos();
		preencheExpDocente();
		preencheExpRelevante();
		preenchePublicacoes();
	}
	
	public void preencheTitulos()
	{
		if(curriculo!=null)
		{
			titulos_panel.removeAll();
			//
			TitulosGroup = new ButtonGroup();
			for(Titulo ti : curriculo.getTitulos())
			{
				JRadioButton rb = new JRadioButton(ti.toString());
				titulos_panel.add(rb);
				TitulosGroup.add(rb);
			}
		}
	}
	
	public void preencheExpDocente()
	{
		if(curriculo!=null)
		{
			expDocente_panel.removeAll();
			//
			expDocenteGroup = new ButtonGroup();
			for(ExpDocente expDoc : curriculo.getExpsDocente())
			{
				JRadioButton rb = new JRadioButton(expDoc.toString());
				expDocente_panel.add(rb);
				expDocenteGroup.add(rb);
			}
		}
	}
	
	public void preencheExpRelevante()
	{
		if(curriculo!=null)
		{
			expRelevante_panel.removeAll();
			//
			expRelevanteGroup = new ButtonGroup();
			for(ExpRelevante expRel : curriculo.getExpsRelevante())
			{
				JRadioButton rb = new JRadioButton(expRel.toString());
				expRelevante_panel.add(rb);
				expRelevanteGroup.add(rb);
			}
		}
	}
	
	public void preenchePublicacoes()
	{
		if(curriculo!=null)
		{
			publicacoes_panel.removeAll();
			//
			publicacoesGroup = new ButtonGroup();
			for(Publicacao pub : curriculo.getPublicacoes())
			{
				JRadioButton rb = new JRadioButton(pub.toString());
				publicacoes_panel.add(rb);
				publicacoesGroup.add(rb);
			}
		}
	}
	
	public void salvar()
	{
		
		curriculo.setReg_profissional(reg_profissional_text.getText());
		curriculo.setEmail(email_text.getText());
		curriculo.setCpf(cpf_text.getText());
		curriculo.setEndereco(endereco_text.getText());
		curriculo.setNome(nome_text.getText());
		curriculo.setTelefone(telefone_forText.getText());	
		if(novo)
			controller.add(curriculo);
		else
			controller.uptade(curriculo);
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initComponents()
	{
		setTitle("Currículo");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 0,grow");
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow,right]", "[][grow][][][grow]"));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_5, "cell 0 0,grow");
		panel_5.setLayout(new MigLayout("", "[][grow,fill]", "[][][][][]"));
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		panel_5.add(lblDadosPessoais, "cell 0 0");
		
		JLabel lblNome = new JLabel("Nome:");
		panel_5.add(lblNome, "cell 0 1,alignx right");
		
		JPanel panel_4 = new JPanel();
		panel_5.add(panel_4, "cell 1 1");
		panel_4.setLayout(new MigLayout("", "[grow]", "[]"));
		
		nome_text = new JTextField();
		nome_text.setToolTipText("Digite o nome");
		panel_4.add(nome_text, "cell 0 0,growx");
		nome_text.setColumns(10);
		nome_text.setText(curriculo.getNome());
		
		JLabel lblEndereo = new JLabel("Endereço:");
		panel_5.add(lblEndereo, "cell 0 2,alignx right");
		
		JPanel panel_3 = new JPanel();
		panel_5.add(panel_3, "cell 1 2");
		panel_3.setLayout(new MigLayout("", "[grow]", "[]"));
		
		endereco_text = new JTextField();
		panel_3.add(endereco_text, "cell 0 0,growx");
		endereco_text.setColumns(10);
		endereco_text.setText(curriculo.getEndereco());
		
		JLabel lblTelefone = new JLabel("Telefone:");
		panel_5.add(lblTelefone, "cell 0 3,alignx right");
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1, "cell 1 3");
		panel_1.setLayout(new MigLayout("", "[130px:n][][][grow]", "[]"));
		
		MaskFormatter telefoneFormatter = null;
		try {
			telefoneFormatter = new MaskFormatter("(##) ####-####");
			telefoneFormatter.setValidCharacters("0123456789");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telefone_forText = new JFormattedTextField(telefoneFormatter);
		panel_1.add(telefone_forText, "cell 0 0,growx");
		
		JLabel lblEmail = new JLabel("Email:");
		panel_1.add(lblEmail, "cell 2 0,alignx trailing");
		
		email_text = new JTextField();
		panel_1.add(email_text, "cell 3 0,growx");
		email_text.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		panel_5.add(lblCpf, "cell 0 4,alignx right");
		
		JPanel panel_2 = new JPanel();
		panel_5.add(panel_2, "cell 1 4");
		panel_2.setLayout(new MigLayout("", "[130px:n][][][grow]", "[]"));
		
		cpf_text = new JTextField();
		cpf_text.setToolTipText("Digite o cpf (Somente números)");
		panel_2.add(cpf_text, "cell 0 0,growx");
		
		JLabel lblRegistroProfissional = new JLabel("Registro Profissional:");
		panel_2.add(lblRegistroProfissional, "cell 2 0,alignx trailing");
		
		regProfissional_text = new JTextField();
		panel_2.add(regProfissional_text, "cell 3 0,growx");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_6, "cell 0 1,grow");
		panel_6.setLayout(new MigLayout("", "[grow,fill]", "[][70px:n,grow][grow]"));
		
		JLabel lblTitulaes = new JLabel("Titulações");
		panel_6.add(lblTitulaes, "cell 0 0");
		
		titulos_panel = new JPanel();
		panel_6.add(titulos_panel, "cell 0 1,grow");
		this.titulos_panel.setLayout(new BoxLayout(this.titulos_panel, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, "cell 0 2,alignx left,growy");
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar = new JButton("Adicionar"); //Botão adicionar (Titulo)
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Cria uma nova janela JTitulo (extends JInternalFrame)
				 * Define os atributos
				 * Adiciona um InternalFrameListener (Escuta), responsável por tratar operações relacionadas à janela.
				 * Definimos apenas instruções para quando a janela for fechada (internalFrameClosed).
				 * É chamado o método preencheTitulos, responsável por atualizar os RadioButton's dentro do panel. 
				 */
				JTitulo jtitu = new JTitulo(curriculo.getTitulos());
				jtitu.setVisible(true);
				jtitu.setClosable(true);
				jtitu.setMaximizable(false);
				jtitu.addInternalFrameListener(new InternalFrameListener() {
					
					@Override
					public void internalFrameOpened(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameIconified(InternalFrameEvent e) {	}
					
					@Override
					public void internalFrameDeiconified(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameDeactivated(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosed(InternalFrameEvent e) {
						preencheTitulos();
					}
					
					@Override
					public void internalFrameActivated(InternalFrameEvent e) {}
				});
				JCurriculo.this.getDesktopPane().add(jtitu);
				try {
					jtitu.setMaximum(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		});
		panel_8.add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<titulos_panel.getComponentCount();i++)
				{
					if(((JRadioButton)titulos_panel.getComponent(i)).isSelected())
					{
						JTitulo jtitu = new JTitulo(curriculo.getTitulos(), i);
						jtitu.setVisible(true);
						jtitu.setClosable(true);
						jtitu.setMaximizable(false);
						jtitu.addInternalFrameListener(new InternalFrameListener() {
							
							@Override
							public void internalFrameOpened(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameIconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeiconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeactivated(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosing(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosed(InternalFrameEvent e) {
								preencheTitulos();
							}
							
							@Override
							public void internalFrameActivated(InternalFrameEvent e) {}
						});
						JCurriculo.this.getDesktopPane().add(jtitu);
						try {
							jtitu.setMaximum(true);
						} catch (PropertyVetoException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		});
		panel_8.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<titulos_panel.getComponentCount();i++)
				{
					if(((JRadioButton)titulos_panel.getComponent(i)).isSelected())
					{
						curriculo.getTitulos().remove(i);
						titulos_panel.remove(i);
						titulos_panel.repaint();
						break;
					}
				}
			}
		});
		panel_8.add(btnExcluir);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_9, "cell 0 2,grow");
		panel_9.setLayout(new MigLayout("", "[grow]", "[][70px:n,grow][]"));
		
		JLabel lblExperinaProficionalDoente = new JLabel("Experiência Profissional Docente");
		panel_9.add(lblExperinaProficionalDoente, "cell 0 0");
		
		expDocente_panel = new JPanel();
		panel_9.add(expDocente_panel, "cell 0 1,grow");
		expDocente_panel.setLayout(new BoxLayout(expDocente_panel, BoxLayout.Y_AXIS));
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, "cell 0 2,grow");
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Cria uma nova janela JExpDocente (extends JInternalFrame)
				 * Define os atributos
				 * Adiciona um InternalFrameListener (Escuta), responsável por tratar operações relacionadas à janela.
				 * Definimos apenas instruções para quando a janela for fechada (internalFrameClosed).
				 * É chamado o método preencheExpDocente, responsável por atualizar os RadioButton's dentro do panel. 
				 */
				JExpDocente jexpDoc = new JExpDocente(curriculo.getExpsDocente());
				jexpDoc.setVisible(true);
				jexpDoc.setClosable(true);
				jexpDoc.setMaximizable(false);
				jexpDoc.addInternalFrameListener(new InternalFrameListener() {
					
					@Override
					public void internalFrameOpened(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameIconified(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameDeiconified(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameDeactivated(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosed(InternalFrameEvent e) {
						preencheExpDocente();
					}
					
					@Override
					public void internalFrameActivated(InternalFrameEvent e) {}
				});
				JCurriculo.this.getDesktopPane().add(jexpDoc);
				try {
					jexpDoc.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_11.add(btnAdicionar_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<expDocente_panel.getComponentCount();i++)
				{
					if(((JRadioButton)expDocente_panel.getComponent(i)).isSelected())
					{
						JExpDocente jexpDoc = new JExpDocente(curriculo.getExpsDocente(), i);
						jexpDoc.setVisible(true);
						jexpDoc.setClosable(true);
						jexpDoc.setMaximizable(false);
						jexpDoc.addInternalFrameListener(new InternalFrameListener() {
							
							@Override
							public void internalFrameOpened(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameIconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeiconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeactivated(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosing(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosed(InternalFrameEvent e) {
								preencheExpDocente();
							}
							
							@Override
							public void internalFrameActivated(InternalFrameEvent e) {}
						});
						JCurriculo.this.getDesktopPane().add(jexpDoc);
						try {
							jexpDoc.setMaximum(true);
						} catch (PropertyVetoException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		});
		panel_11.add(btnEditar_1);
		
		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<expDocente_panel.getComponentCount();i++)
				{
					if(((JRadioButton)expDocente_panel.getComponent(i)).isSelected())
					{
						curriculo.getExpsDocente().remove(i);
						expDocente_panel.remove(i);
						expDocente_panel.repaint();
						break;
					}
				}
			}
		});
		panel_11.add(btnExcluir_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_12, "cell 0 3,grow");
		panel_12.setLayout(new MigLayout("", "[grow]", "[][70px:n,grow][grow]"));
		
		JLabel lblExperinciaProfissionalRelevante = new JLabel("Experiência Profissional Relevante");
		panel_12.add(lblExperinciaProfissionalRelevante, "cell 0 0");
		
		expRelevante_panel = new JPanel();
		panel_12.add(expRelevante_panel, "cell 0 1,grow");
		expRelevante_panel.setLayout(new BoxLayout(expRelevante_panel, BoxLayout.Y_AXIS));
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, "cell 0 2,grow");
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar_2 = new JButton("Adicionar");
		btnAdicionar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Cria uma nova janela JExpRelevante (extends JInternalFrame)
				 * Define os atributos
				 * Adiciona um InternalFrameListener (Escuta), responsável por tratar operações relacionadas à janela.
				 * Definimos apenas instruções para quando a janela for fechada (internalFrameClosed).
				 * É chamado o método preencheExpRelevante, responsável por atualizar os RadioButton's dentro do panel. 
				 */
				JExpRelevante jexpRel = new JExpRelevante(curriculo.getExpsRelevante());
				jexpRel.setVisible(true);
				jexpRel.setClosable(true);
				jexpRel.setMaximizable(false);
				jexpRel.addInternalFrameListener(new InternalFrameListener() {
					
					@Override
					public void internalFrameOpened(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameIconified(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameDeiconified(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameDeactivated(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosed(InternalFrameEvent e) {
						preencheExpRelevante();
					}
					
					@Override
					public void internalFrameActivated(InternalFrameEvent e) {}
				});
				JCurriculo.this.getDesktopPane().add(jexpRel);
				try {
					jexpRel.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_14.add(btnAdicionar_2);
		
		JButton btnEditar_2 = new JButton("Editar");
		btnEditar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<expRelevante_panel.getComponentCount();i++)
				{
					if(((JRadioButton)expRelevante_panel.getComponent(i)).isSelected())
					{
						JExpRelevante jexpRel = new JExpRelevante(curriculo.getExpsRelevante(), i);
						jexpRel.setVisible(true);
						jexpRel.setClosable(true);
						jexpRel.setMaximizable(false);
						jexpRel.addInternalFrameListener(new InternalFrameListener() {
							
							@Override
							public void internalFrameOpened(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameIconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeiconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeactivated(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosing(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosed(InternalFrameEvent e) {
								preencheExpRelevante();
							}
							
							@Override
							public void internalFrameActivated(InternalFrameEvent e) {}
						});
						JCurriculo.this.getDesktopPane().add(jexpRel);
						try {
							jexpRel.setMaximum(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						break;
					}
				}
			}
		});
		panel_14.add(btnEditar_2);
		
		JButton btnExcluir_2 = new JButton("Excluir");
		btnExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<expRelevante_panel.getComponentCount();i++)
				{
					if(((JRadioButton)expRelevante_panel.getComponent(i)).isSelected())
					{
						curriculo.getExpsDocente().remove(i);
						expRelevante_panel.remove(i);
						expRelevante_panel.repaint();
						break;
					}
				}
			}
		});
		panel_14.add(btnExcluir_2);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_15, "cell 0 4,grow");
		panel_15.setLayout(new MigLayout("", "[grow]", "[][70px:n,grow][grow]"));
		
		JLabel lblPublicaes = new JLabel("Publicações");
		panel_15.add(lblPublicaes, "cell 0 0");
		
		publicacoes_panel = new JPanel();
		panel_15.add(publicacoes_panel, "cell 0 1,grow");
		publicacoes_panel.setLayout(new BoxLayout(publicacoes_panel, BoxLayout.Y_AXIS));
		
		JPanel panel_17 = new JPanel();
		panel_15.add(panel_17, "cell 0 2,grow");
		panel_17.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar_3 = new JButton("Adicionar");
		btnAdicionar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPublicacao jpubl = new JPublicacao(curriculo.getPublicacoes());
				jpubl.setVisible(true);
				jpubl.setClosable(true);
				jpubl.setMaximizable(false);
				jpubl.addInternalFrameListener(new InternalFrameListener() {
					
					@Override
					public void internalFrameOpened(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameIconified(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameDeiconified(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameDeactivated(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosing(InternalFrameEvent e) {}
					
					@Override
					public void internalFrameClosed(InternalFrameEvent e) {
						preenchePublicacoes();
					}
					
					@Override
					public void internalFrameActivated(InternalFrameEvent e) {}
				});
				JCurriculo.this.getDesktopPane().add(jpubl);
				try {
					jpubl.setMaximum(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		});
		panel_17.add(btnAdicionar_3);
		
		JButton btnEditar_3 = new JButton("Editar");
		btnEditar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<publicacoes_panel.getComponentCount();i++)
				{
					if(((JRadioButton)publicacoes_panel.getComponent(i)).isSelected())
					{
						JPublicacao jpubl = new JPublicacao(curriculo.getPublicacoes(), i);
						jpubl.setVisible(true);
						jpubl.setClosable(true);
						jpubl.setMaximizable(false);
						jpubl.addInternalFrameListener(new InternalFrameListener() {
							
							@Override
							public void internalFrameOpened(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameIconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeiconified(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameDeactivated(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosing(InternalFrameEvent e) {}
							
							@Override
							public void internalFrameClosed(InternalFrameEvent e) {
								preenchePublicacoes();
							}
							
							@Override
							public void internalFrameActivated(InternalFrameEvent e) {}
						});
						JCurriculo.this.getDesktopPane().add(jpubl);
						try {
							jpubl.setMaximum(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						break;
					}
				}
			}
		});
		panel_17.add(btnEditar_3);
		
		JButton btnExcluir_3 = new JButton("Excluir");
		btnExcluir_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<publicacoes_panel.getComponentCount();i++)
				{
					if(((JRadioButton)publicacoes_panel.getComponent(i)).isSelected())
					{
						curriculo.getPublicacoes().remove(i);
						publicacoes_panel.remove(i);
						publicacoes_panel.repaint();
						break;
					}
				}
			}
		});
		panel_17.add(btnExcluir_3);
		
		JPanel panel_18 = new JPanel();
		getContentPane().add(panel_18, "cell 0 1,grow");
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		panel_18.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCurriculo.this.setVisible(false);
			}
		});
		panel_18.add(btnCancelar);
	}
	
}
