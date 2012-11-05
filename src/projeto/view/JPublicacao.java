package projeto.view;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import projeto.models.Publicacao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class JPublicacao extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	//
	private Publicacao publicacao;
	private LinkedList<Publicacao> publicacoes;

	/**
	 * Create the frame.
	 */
	boolean novo = true;
	/**
	 * @wbp.parser.constructor
	 */
	public JPublicacao(LinkedList<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
		this.publicacao = new Publicacao("","","","",GregorianCalendar.getInstance().get(GregorianCalendar.YEAR));
		initComponents();
	}
	public JPublicacao(LinkedList<Publicacao> publicacoes, int indicePublicacao)
	{
		this.publicacoes = publicacoes;
		
		if(indicePublicacao<publicacoes.size())
		{
			this.publicacao = this.publicacoes.get(indicePublicacao);
			novo=false;
		}
		else
		{
			publicacao = new Publicacao("","","","",GregorianCalendar.getInstance().get(GregorianCalendar.YEAR));
			novo=true;
		}
		initComponents();
	}
	public void salvar(){
		if(novo)
			this.publicacoes.add(this.publicacao);
	}
	

	public void initComponents()
	{
		setTitle("Publicação");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 660, 433);
		getContentPane().setLayout(new MigLayout("", "[][100px:n]", "[][][][][][]"));
		
		JLabel lblTtuloDaPublicao = new JLabel("Título da Publicação");
		getContentPane().add(lblTtuloDaPublicao, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		textField.setText(publicacao.getTitulo());
		getContentPane().add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblAutores = new JLabel("Autores");
		getContentPane().add(lblAutores, "cell 0 1,alignx trailing");
		
		textField_2 = new JTextField();
		textField.setText(publicacao.getAutores());
		getContentPane().add(textField_2, "cell 1 1,growx");
		textField_2.setColumns(10);
		
		JLabel lblEvento = new JLabel("Evento");
		getContentPane().add(lblEvento, "cell 0 2,alignx trailing");
		
		textField_1 = new JTextField();
		textField.setText(publicacao.getEvento());
		getContentPane().add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblAnoDaPublicao = new JLabel("Ano da Publicação");
		getContentPane().add(lblAnoDaPublicao, "cell 0 3,alignx trailing");
		
		textField_3 = new JTextField();
		textField.setText(String.valueOf(publicacao.getAno()));
		getContentPane().add(textField_3, "cell 1 3,growx");
		textField_3.setColumns(10);
		
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
