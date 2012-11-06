package projeto.view;

import javax.swing.JInternalFrame;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import net.miginfocom.swing.MigLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import projeto.models.ExpRelevante;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

public class JExpRelevante extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField data_inicio_text;
	private JTextField data_termino_text;
	private JTextField descricao_text;
	private JTextField instituicao_text;
	private JTextField cidade_text;
	private JTextField estado_text;
	private LinkedList <ExpRelevante> exps;
	private ExpRelevante exp;
	private boolean novo=true;
	
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public JExpRelevante(LinkedList<ExpRelevante>exps) {
		this.exps=exps;
		exp = new ExpRelevante(1900, GregorianCalendar.getInstance().get(GregorianCalendar.YEAR),"","","","");
		novo=true;
		initComponents();
	}
	
	public JExpRelevante(LinkedList<ExpRelevante>exps, int indiceExpDocente)
	{
		this.exps=exps;
		if(indiceExpDocente<exps.size())
		{
			exp = exps.get(indiceExpDocente);
			novo=false;
		}
		else{
			exp = new ExpRelevante(1900, GregorianCalendar.getInstance().get(GregorianCalendar.YEAR),"","","","");
			novo=true;
			}
		initComponents();
	}
	
	public void salvar()
	{
		exp.setCidade(cidade_text.getText());
		try
		{
			exp.setData_fim(Integer.parseInt(data_termino_text.getText()));
			exp.setData_inicio(Integer.parseInt(data_inicio_text.getText()));
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informe um ano válido!");
			return;
		}
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
		setTitle("Experiencia Relevante");
		setBounds(100, 100, 530, 318);
		getContentPane().setLayout(new MigLayout("", "[][150px:n][][30px:n]", "[][][][][][]"));
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		getContentPane().add(lblDataDeIncio, "cell 0 0,alignx trailing");
		
		data_inicio_text = new JTextField();
		data_inicio_text.setText(String.valueOf(this.exp.getData_inicio()));
		getContentPane().add(data_inicio_text, "cell 1 0,growx");
		data_inicio_text.setColumns(10);
		
		JLabel lblData = new JLabel("Data de término:");
		getContentPane().add(lblData, "cell 0 1,alignx trailing");
		
		data_termino_text = new JTextField();
		data_inicio_text.setText(String.valueOf(exp.getData_fim()));
		getContentPane().add(data_termino_text, "cell 1 1,growx");
		data_termino_text.setColumns(10);
		
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
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		getContentPane().add(btnSalvar, "cell 0 5,alignx right");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JExpRelevante.this.setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnCancelar, "cell 1 5");
		
	}
	
	
}
