package projeto.util;

import javax.swing.JOptionPane;

public abstract class GetData {

	private GetData(){  };
	
	/**
	 * @param message
	 * @return
	 */
	
	public static int getInt(String message)
	{
		boolean errado=true;
		int v = 0;
		while(errado)
		{
			try
			{
				v = Integer.parseInt(JOptionPane.showInputDialog(message));
				errado=false;
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite um n�mero v�lido.");
				errado=true;
			}
		}
		return v;
	}
	
	public static double getDouble(String message)
	{
		boolean errado=true;
		double v = 0.0;
		while(errado)
		{
			try
			{
				v = Double.parseDouble(JOptionPane.showInputDialog(message));
				errado=false;
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite um n�mero v�lido.");
				errado=true;
			}
		}
		return v;
	}
	
}
