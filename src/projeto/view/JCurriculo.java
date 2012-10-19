package projeto.view;

import javax.swing.JInternalFrame;

import projeto.models.Curriculo;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JCurriculo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Curriculo curriculo;
	private JTextField nome_text;
	private JTextField endereco_text;
	private JTextField email_text;
	
	public JCurriculo(Curriculo curriculo)
	{
		if(curriculo!=null)
			this.curriculo = curriculo;
		else
			this.curriculo = new Curriculo("", "", "", "", 0, 0);
		
		setTitle("Currículo");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 0,grow");
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow,right]", "[][][][][grow]"));
		
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
		JFormattedTextField telefone_forText = new JFormattedTextField(telefoneFormatter);
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
		
		MaskFormatter cpfFm = null;
		try
		{
			cpfFm = new MaskFormatter("###.###.###-##");
			cpfFm.setValidCharacters("0123456789");
		}catch (ParseException e) {
			// TODO: handle exception
		}
		JFormattedTextField cpf_forText = new JFormattedTextField(cpfFm);
		cpf_forText.setToolTipText("Digite o cpf (Somente números)");
		panel_2.add(cpf_forText, "cell 0 0,growx");
		
		JLabel lblRegistroProfissional = new JLabel("Registro Profissional:");
		panel_2.add(lblRegistroProfissional, "cell 2 0,alignx trailing");
		
		JFormattedTextField regProfissional_forText = new JFormattedTextField();
		regProfissional_forText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				boolean isDigit=false;
				for(char c : "0123456789".toCharArray())
				{
					if(c==e.getKeyChar())
					{
						isDigit=true;
						break;
					}
				}
				if(!isDigit)
				{
					e.consume();
					System.out.println("não é dígito!");
				}
			}
		});
		panel_2.add(regProfissional_forText, "cell 3 0,growx");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_6, "cell 0 1,grow");
		panel_6.setLayout(new MigLayout("", "[grow,fill]", "[][grow][grow]"));
		
		JLabel lblTitulaes = new JLabel("Titulações");
		panel_6.add(lblTitulaes, "cell 0 0");
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, "cell 0 1,grow");
		panel_7.setLayout(new MigLayout("", "[499px]", "[23px]"));
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, "cell 0 2,alignx left,growy");
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar = new JButton("Adicionar");
		panel_8.add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		panel_8.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		panel_8.add(btnExcluir);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_9, "cell 0 2,grow");
		panel_9.setLayout(new MigLayout("", "[grow]", "[][][]"));
		
		JLabel lblExperinaProficionalDoente = new JLabel("Experiência Profissional Docente");
		panel_9.add(lblExperinaProficionalDoente, "cell 0 0");
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10, "cell 0 1,grow");
		panel_10.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, "cell 0 2,grow");
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar_1 = new JButton("Adicionar");
		panel_11.add(btnAdicionar_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		panel_11.add(btnEditar_1);
		
		JButton btnExcluir_1 = new JButton("Excluir");
		panel_11.add(btnExcluir_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_12, "cell 0 3,grow");
		panel_12.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
		
		JLabel lblExperinciaProfissionalRelevante = new JLabel("Experiência Profissional Relevante");
		panel_12.add(lblExperinciaProfissionalRelevante, "cell 0 0");
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13, "cell 0 1,grow");
		panel_13.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, "cell 0 2,grow");
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar_2 = new JButton("Adicionar");
		panel_14.add(btnAdicionar_2);
		
		JButton btnEditar_2 = new JButton("Editar");
		panel_14.add(btnEditar_2);
		
		JButton btnExcluir_2 = new JButton("Excluir");
		panel_14.add(btnExcluir_2);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_15, "cell 0 4,grow");
		panel_15.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
		
		JLabel lblPublicaes = new JLabel("Publicações");
		panel_15.add(lblPublicaes, "cell 0 0");
		
		JPanel panel_16 = new JPanel();
		panel_15.add(panel_16, "cell 0 1,grow");
		panel_16.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_17 = new JPanel();
		panel_15.add(panel_17, "cell 0 2,grow");
		panel_17.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdicionar_3 = new JButton("Adicionar");
		panel_17.add(btnAdicionar_3);
		
		JButton btnEditar_3 = new JButton("Editar");
		panel_17.add(btnEditar_3);
		
		JButton btnExcluir_3 = new JButton("Excluir");
		panel_17.add(btnExcluir_3);
		
		JPanel panel_18 = new JPanel();
		getContentPane().add(panel_18, "cell 0 1,grow");
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSalvar = new JButton("Salvar");
		panel_18.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_18.add(btnCancelar);
	}

}
