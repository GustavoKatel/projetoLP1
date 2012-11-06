package projeto.view;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.JInternalFrame;

import projeto.models.Titulo;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

public class JTitulo extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private LinkedList<Titulo> titulos;
	private Titulo titulo;
	private JTextField curso_text;
	private JTextField instituicao_text;
	private JTextField cidade_text;
	private JFormattedTextField ano_forText;
	private JComboBox tipo_combo;
	private JFormattedTextField uf_forText;

	private boolean novo=false;
	
	/**
	 * @wbp.parser.constructor
	 */
	public JTitulo(LinkedList<Titulo> titulos)
	{
		titulo = new Titulo(GregorianCalendar.getInstance().get(GregorianCalendar.YEAR), 
				"", "", "", "", "");
		this.titulos = titulos;
		novo = true;
		//
		initComponents();
	}
	
	/**
	 * @param indiceCurriculo
	 * @param indiceTitulo
	 */
	public JTitulo(LinkedList<Titulo> titulos, int indiceTitulo)
	{
		this.titulos = titulos;
		if(indiceTitulo<titulos.size())
		{
			titulo = titulos.get(indiceTitulo);
			novo=false;
		}
		else
		{
			titulo = new Titulo(GregorianCalendar.getInstance().get(GregorianCalendar.YEAR), 
					"", "", "", "", "");
			novo=true;
		}
		//
		initComponents();
	}

	public void salvar()
	{
		try
		{
			titulo.setAno(Integer.parseInt(ano_forText.getText()));
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite um ano válido!");
		}
		titulo.setFormacao(tipo_combo.getSelectedItem().toString());
		titulo.setCurso(curso_text.getText());
		titulo.setInstituicao(instituicao_text.getText());
		titulo.setCidade(cidade_text.getText());
		titulo.setEstado(uf_forText.getText());
		if(novo)
			titulos.add(titulo);
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initComponents()
	{
		setTitle("Título");
		setResizable(true);
		setClosable(true);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][grow]"));
		
		JLabel lblAnoDeConcluso = new JLabel("Ano de conclusão:");
		getContentPane().add(lblAnoDeConcluso, "cell 0 0,alignx right");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[130px:n]", "[19px]"));
		
		MaskFormatter anoFm = null;
		try
		{
			anoFm = new MaskFormatter("####");
			anoFm.setValidCharacters("0123456789");
		}catch (ParseException e) {
			// TODO: handle exception
		}
		ano_forText = new JFormattedTextField(anoFm);
		ano_forText.setToolTipText("Ano (AAAA)");
		ano_forText.setText(String.valueOf(titulo.getAno()));
		panel.add(ano_forText, "cell 0 0,growx");
		
		JLabel lblNewLabel = new JLabel("Tipo de formação:");
		getContentPane().add(lblNewLabel, "cell 0 1,alignx right");
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new MigLayout("", "[130px:n]", "[]"));
		
		tipo_combo = new JComboBox();
		tipo_combo.setModel(new DefaultComboBoxModel(new String[] {"Bacharelado", "Licenciatura", "Tecnólogo", "Especialização", "Mestrado", "Doutorado"}));
		panel_1.add(tipo_combo, "cell 0 0,growx");
		
		JLabel lblCurso = new JLabel("Curso:");
		getContentPane().add(lblCurso, "cell 0 2,alignx right");
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, "cell 1 2,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[19px]"));
		
		curso_text = new JTextField();
		panel_2.add(curso_text, "cell 0 0,growx,aligny top");
		curso_text.setColumns(10);
		curso_text.setText(titulo.getCurso());
		
		JLabel lblInstituio = new JLabel("Instituição:");
		getContentPane().add(lblInstituio, "cell 0 3,alignx right");
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, "cell 1 3,grow");
		panel_3.setLayout(new MigLayout("", "[grow]", "[19px]"));
		
		instituicao_text = new JTextField();
		panel_3.add(instituicao_text, "cell 0 0,growx,aligny top");
		instituicao_text.setColumns(10);
		instituicao_text.setText(titulo.getInstituicao());
		
		JLabel lblCidade = new JLabel("Cidade:");
		getContentPane().add(lblCidade, "cell 0 4,alignx right");
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, "cell 1 4,grow");
		panel_4.setLayout(new MigLayout("", "[234px,grow][][][130px:n]", "[19px]"));
		
		cidade_text = new JTextField();
		panel_4.add(cidade_text, "cell 0 0,growx,aligny top");
		cidade_text.setColumns(10);
		cidade_text.setText(titulo.getCidade());
		
		JLabel lblUf = new JLabel("UF:");
		panel_4.add(lblUf, "cell 2 0,alignx trailing");
		
		uf_forText = new JFormattedTextField();
		uf_forText.setToolTipText("Unidade Federativa (Somente letras maiúsculas)");
		uf_forText.setText(titulo.getEstado());
		panel_4.add(uf_forText, "cell 3 0,growx");
		
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5, "cell 1 5,alignx left,growy");
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				salvar();
			}
		});
		panel_5.add(btnNewButton);
		
		JButton btnFechar = new JButton("Cancelar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JTitulo.this.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel_5.add(btnFechar);
	}

}
