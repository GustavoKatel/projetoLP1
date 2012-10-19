package projeto.view;

import java.util.GregorianCalendar;

import javax.swing.JInternalFrame;

import projeto.models.Titulo;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JTitulo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Titulo titulo;
	private JTextField ano_text;
	private JTextField curso_text;
	private JTextField instituicao_text;
	private JTextField cidade_text;
	private JTextField uf_text;
	
	public JTitulo(Titulo titulo)
	{
		setTitle("Título");
		setResizable(true);
		setClosable(true);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblAnoDeConcluso = new JLabel("Ano de conclusão:");
		getContentPane().add(lblAnoDeConcluso, "cell 0 0,alignx right");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 1 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[19px]"));
		
		ano_text = new JTextField();
		panel.add(ano_text, "cell 0 0,alignx left,aligny top");
		ano_text.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tipo de formação:");
		getContentPane().add(lblNewLabel, "cell 0 1,alignx right");
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
		
		JComboBox tipo_combo = new JComboBox();
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
		
		JLabel lblInstituio = new JLabel("Instituição:");
		getContentPane().add(lblInstituio, "cell 0 3,alignx right");
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, "cell 1 3,grow");
		panel_3.setLayout(new MigLayout("", "[grow]", "[19px]"));
		
		instituicao_text = new JTextField();
		panel_3.add(instituicao_text, "cell 0 0,growx,aligny top");
		instituicao_text.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		getContentPane().add(lblCidade, "cell 0 4,alignx right");
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, "cell 1 4,grow");
		panel_4.setLayout(new MigLayout("", "[234px,grow][][][]", "[19px]"));
		
		cidade_text = new JTextField();
		panel_4.add(cidade_text, "cell 0 0,growx,aligny top");
		cidade_text.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		panel_4.add(lblUf, "cell 2 0");
		
		uf_text = new JTextField();
		panel_4.add(uf_text, "cell 3 0");
		uf_text.setColumns(10);
		if(titulo!=null)
			this.titulo = titulo;
		else
			this.titulo = new Titulo(GregorianCalendar.getInstance().get(GregorianCalendar.YEAR), "", "", "", "", "");
	}

}
