package projeto.view;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class JAbout extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEquipe;
	private JLabel lblArthurChacon;
	private JLabel lblCceroMarcelo;
	private JLabel lblGustavoBrito;
	private JLabel lblRodolfoStrunkis;
	private JLabel lblCadastroDeCurrculos;
	private JLabel lblLinguagemDeProgramao;
	public JAbout() {
		initComponents();
	}
	private void initComponents() {
		setTitle("Sobre");
		setClosable(true);
		getContentPane().setLayout(new MigLayout("", "[][][]", "[][][][][]"));
		
		this.lblEquipe = new JLabel("Equipe:");
		getContentPane().add(this.lblEquipe, "cell 0 0");
		
		this.lblCadastroDeCurrculos = new JLabel("Cadastro de Currículos");
		getContentPane().add(this.lblCadastroDeCurrculos, "cell 2 0");
		
		this.lblArthurChacon = new JLabel("Arthur Chacon - 11121216");
		getContentPane().add(this.lblArthurChacon, "cell 0 1");
		
		this.lblLinguagemDeProgramao = new JLabel("Linguagem de Programação 1");
		getContentPane().add(this.lblLinguagemDeProgramao, "cell 2 1");
		
		this.lblCceroMarcelo = new JLabel("Cícero Marcelo - 11121217");
		getContentPane().add(this.lblCceroMarcelo, "cell 0 2");
		
		this.lblGustavoBrito = new JLabel("Gustavo Brito - 11118146");
		getContentPane().add(this.lblGustavoBrito, "cell 0 3");
		
		this.lblRodolfoStrunkis = new JLabel("Rodolfo Strunkis - 11121697");
		getContentPane().add(this.lblRodolfoStrunkis, "cell 0 4");
	}

}
