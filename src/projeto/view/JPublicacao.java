package projeto.view;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import projeto.models.Publicacao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class JPublicacao extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField titulo_text;
	private JTextField evento_text;
	private JTextField autores_text;
	private JTextField ano_text;
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
		publicacao.setTitulo(titulo_text.getText());
		try
		{
			publicacao.setAno(Integer.parseInt(ano_text.getText()));
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informe um ano válido!");
			return;
		}
		//publicacao.setArea(area_)
		publicacao.setAutores(autores_text.getText());
		publicacao.setEvento(evento_text.getText());
		if(novo)
			publicacoes.add(publicacao);
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		titulo_text = new JTextField();
		titulo_text.setText(publicacao.getTitulo());
		getContentPane().add(titulo_text, "cell 1 0,growx");
		titulo_text.setColumns(10);
		
		JLabel lblAutores = new JLabel("Autores");
		getContentPane().add(lblAutores, "cell 0 1,alignx trailing");
		
		autores_text = new JTextField();
		autores_text.setText(publicacao.getAutores());
		getContentPane().add(autores_text, "cell 1 1,growx");
		autores_text.setColumns(10);
		
		JLabel lblEvento = new JLabel("Evento");
		getContentPane().add(lblEvento, "cell 0 2,alignx trailing");
		
		evento_text = new JTextField();
		evento_text.setText(publicacao.getEvento());
		getContentPane().add(evento_text, "cell 1 2,growx");
		evento_text.setColumns(10);
		
		JLabel lblAnoDaPublicao = new JLabel("Ano da Publicação");
		getContentPane().add(lblAnoDaPublicao, "cell 0 3,alignx trailing");
		
		ano_text = new JTextField();
		ano_text.setText(String.valueOf(publicacao.getAno()));
		getContentPane().add(ano_text, "cell 1 3,growx");
		ano_text.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		getContentPane().add(btnSalvar, "cell 0 5,alignx right");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JPublicacao.this.setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnCancelar, "cell 1 5");
	}
	
}
