package projeto.view;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;

import projeto.controller.CurriculoController;
import projeto.models.Curriculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

public class JConsulta extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNome;
	private JTextField nome_text;
	private JPanel panel;
	private JButton btnConsultar;

	/**
	 * Create the frame.
	 */
	public JConsulta() {

		initComponents();
	}
	
	public void consultar()
	{
		if(lblNome.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Digite um nome!");
			return;
		}
		CurriculoController controller = new CurriculoController();
		Curriculo curriculo = controller.find(nome_text.getText());
		if(curriculo==null)
		{
			JOptionPane.showMessageDialog(null, "Currículo não encontrado!");
			return;
		}
		JCurriculo jcur = new JCurriculo(curriculo);
		this.getDesktopPane().add(jcur);
		jcur.setClosable(true);
		jcur.setVisible(true);
		jcur.setMaximizable(false);
		try {
			jcur.setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
	}
	
	private void initComponents() {
		setTitle("Consultar");
		setBounds(100, 100, 339, 198);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		this.lblNome = new JLabel("Nome:");
		getContentPane().add(this.lblNome, "cell 0 0,alignx trailing");
		
		this.nome_text = new JTextField();
		getContentPane().add(this.nome_text, "cell 1 0,growx");
		this.nome_text.setColumns(10);
		
		this.panel = new JPanel();
		getContentPane().add(this.panel, "cell 1 2,grow");
		this.panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.btnConsultar = new JButton("Consultar");
		this.btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		this.panel.add(this.btnConsultar);
	}

}
