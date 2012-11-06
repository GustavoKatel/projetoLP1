package projeto.view;

import javax.swing.JInternalFrame;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import projeto.models.ExpDocente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class JExpDocente extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFormattedTextField data_inicio_text;
	private JFormattedTextField data_termino_text;
	private JTextField descricao_text;
	private JTextField instituicao_text;
	private JTextField cidade_text;
	private JTextField estado_text;
	private LinkedList <ExpDocente> exps;
	private ExpDocente exp;
	private boolean novo=true;
	
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public JExpDocente(LinkedList<ExpDocente>exps) {
		this.exps=exps;
		exp = new ExpDocente(1900, GregorianCalendar.getInstance().get(GregorianCalendar.YEAR),"","","","");
		novo=true;
		initComponents();
	}
	
	public JExpDocente(LinkedList<ExpDocente>exps, int indiceExpDocente)
	{
		this.exps=exps;
		if(indiceExpDocente<exps.size())
		{
			exp = exps.get(indiceExpDocente);
			novo=false;
		}
		else{
			exp = new ExpDocente(1900, GregorianCalendar.getInstance().get(GregorianCalendar.YEAR),"","","","");
			novo=true;
			}
		initComponents();
	}
	
	public void salvar()
	{
		exp.setCidade(cidade_text.getText());
		exp.setData_fim(Integer.parseInt(data_termino_text.getText()));
		exp.setData_inicio(Integer.parseInt(data_inicio_text.getText()));
		exp.setDescricao(descricao_text.getText());
		exp.setEstado(estado_text.getText());
		exp.setInstituicao(instituicao_text.getText());
		if(novo)
			exps.add(exp);
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initComponents()
	{
		setTitle("Experiencia Docente");
		setBounds(100, 100, 530, 318);
		getContentPane().setLayout(new MigLayout("", "[][150px:n,grow][][30px:n]", "[][][][][][]"));
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		getContentPane().add(lblDataDeIncio, "cell 0 0,alignx trailing");
		
		//
		MaskFormatter mFormatterData = null;
		try {
			mFormatterData = new MaskFormatter("####");
			mFormatterData.setValidCharacters("0123456789");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		data_inicio_text = new JFormattedTextField(mFormatterData);
		data_inicio_text.setText(String.valueOf(exp.getData_inicio()));
		getContentPane().add(data_inicio_text, "cell 1 0,growx");
		
		JLabel lblData = new JLabel("Data de término:");
		getContentPane().add(lblData, "cell 0 1,alignx trailing");
		
		data_termino_text = new JFormattedTextField(mFormatterData);
		data_termino_text.setText(String.valueOf(exp.getData_fim()));
		getContentPane().add(data_termino_text, "cell 1 1,growx");
		
		JLabel lblDescrioDaAtividade = new JLabel("Descrição da atividade:");
		getContentPane().add(lblDescrioDaAtividade, "cell 0 2,alignx trailing");
		
		descricao_text = new JTextField();
		descricao_text.setText(this.exp.getDescricao());
		getContentPane().add(descricao_text, "cell 1 2,growx");
		descricao_text.setColumns(10);
		
		JLabel lblInstituio = new JLabel("Instituição:");
		getContentPane().add(lblInstituio, "cell 0 3,alignx trailing");
		
		instituicao_text = new JTextField();
		instituicao_text.setText(this.exp.getInstituicao());
		getContentPane().add(instituicao_text, "cell 1 3,growx");
		instituicao_text.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		getContentPane().add(lblCidade, "cell 0 4,alignx trailing");
		
		cidade_text = new JTextField();
		cidade_text.setText(this.exp.getCidade());
		getContentPane().add(cidade_text, "cell 1 4,growx");
		cidade_text.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		getContentPane().add(lblEstado, "cell 2 4,alignx trailing");
		
		estado_text = new JTextField();
		estado_text.setText(this.exp.getEstado());
		getContentPane().add(estado_text, "cell 3 4");
		estado_text.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		getContentPane().add(btnSalvar, "cell 0 5,alignx right");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JExpDocente.this.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnCancelar, "cell 1 5");
		
	}
	
	
}
