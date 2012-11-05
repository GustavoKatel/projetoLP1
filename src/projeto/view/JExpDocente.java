package projeto.view;

import javax.swing.JInternalFrame;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import projeto.models.ExpDocente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JExpDocente extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
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
		if(novo)
			exps.add(exp);
	}
	
	public void initComponents()
	{
		setTitle("Experiencia Docente");
		setBounds(100, 100, 530, 318);
		getContentPane().setLayout(new MigLayout("", "[][150px:n][][30px:n]", "[][][][][][]"));
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		getContentPane().add(lblDataDeIncio, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		textField.setText(String.valueOf(this.exp.getData_inicio()));
		getContentPane().add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblData = new JLabel("Data de término:");
		getContentPane().add(lblData, "cell 0 1,alignx trailing");
		
		textField_1 = new JTextField();
		textField.setText(String.valueOf(this.exp.getData_fim()));
		getContentPane().add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblDescrioDaAtividade = new JLabel("Descrição da atividade:");
		getContentPane().add(lblDescrioDaAtividade, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setText(this.exp.getDescricao());
		getContentPane().add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblInstituio = new JLabel("Instituição:");
		getContentPane().add(lblInstituio, "cell 0 3,alignx trailing");
		
		textField_3 = new JTextField();
		textField_3.setText(this.exp.getInstituicao());
		getContentPane().add(textField_3, "cell 1 3,growx");
		textField_3.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		getContentPane().add(lblCidade, "cell 0 4,alignx trailing");
		
		textField_4 = new JTextField();
		textField_4.setText(this.exp.getCidade());
		getContentPane().add(textField_4, "cell 1 4,growx");
		textField_4.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		getContentPane().add(lblEstado, "cell 2 4,alignx trailing");
		
		textField_5 = new JTextField();
		textField_5.setText(this.exp.getEstado());
		getContentPane().add(textField_5, "cell 3 4");
		textField_5.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		getContentPane().add(btnSalvar, "cell 0 5,alignx right");
		
		JButton btnCancelar = new JButton("Cancelar");
		getContentPane().add(btnCancelar, "cell 1 5");
		
	}
	
	
}
