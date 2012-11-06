package projeto.controller;

import java.util.LinkedList;
import projeto.models.Curriculo;

public class CurriculoController {

	private static LinkedList<Curriculo> curriculos = null;
	
	public CurriculoController()
	{
		if(curriculos==null)
			curriculos = new LinkedList<Curriculo>();
	}
	
	public boolean add(Curriculo obj) {
		System.out.println("adicionado");
		return curriculos.add(obj);
	}

	public boolean uptade(Curriculo curriculo)
	{
		for(Curriculo c:curriculos)
		{
			if(c.getId()==curriculo.getId())
			{
				c.setNome(curriculo.getNome());
				c.setCpf(curriculo.getCpf());
				c.setEmail(curriculo.getEmail());
				c.setEndereco(curriculo.getEndereco());
				c.setReg_profissional(curriculo.getReg_profissional());
				c.setTelefone(curriculo.getTelefone());
				c.setTitulos(curriculo.getTitulos());
				System.out.println("atualizado");
				return true;
			}
		}
		return false;
	}
	
	public Curriculo get(int i) {
		if(i>curriculos.size())
			return null;
		return curriculos.get(i);
	}

	public Curriculo find(String nome)
	{
		for(Curriculo curriculo : curriculos)
		{
			if(curriculo.getNome().equals(nome))
				return curriculo;
		}
		return null;
	}
	
	public int getSize()
	{
		return curriculos.size();
	}
	
	public boolean save(String filename) {
		/*
		 * 1 - salva todos os currículos em um arquivo
		 * 2 - salva todos os títulos em um arquivo
		 * 3 - salva todos as exps_docentes em um arquivo
		 * 4 - salva todas as exps_relevantes em um arquivo
		 * 5 - salva todas as publicações em um arquivo 
		 * 
		 */
		return false;
	}

	public boolean load(String filename) {
		/*
		 * 1 - carrega todos os currículos
		 * 3 - carrega todos os titulos
		 * 4 - carrega todas as exps_docentes
		 * 5 - carrega todas as exps_relevantes
		 * 6 - carrega todas as publicações 
		 * 
		 */
		return false;
	}

	
}
