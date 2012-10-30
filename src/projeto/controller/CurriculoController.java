package projeto.controller;

import java.util.LinkedList;
import java.util.List;

import projeto.models.Curriculo;

public class CurriculoController {

	private static LinkedList<Curriculo> curriculos = null;
	
	public CurriculoController()
	{
		if(curriculos==null)
			curriculos = new LinkedList<Curriculo>();
	}
	
	public boolean add(Curriculo obj) {
		return curriculos.add(obj);
	}

	public boolean add(List<Curriculo> collection) {
		return curriculos.addAll(collection);
	}
	
	public Curriculo get(int i) {
		if(i>curriculos.size())
			return null;
		return curriculos.get(i);
	}

	public int getSize()
	{
		return curriculos.size();
	}
	
	public boolean save(String filename) {
		/*
		 * 1 - salva todos os tipos primitivos
		 * 2 - salva a quantidade de titulos
		 * 3 - salva todos os titulos
		 * 4 - salva a quantidade de exps_docentes
		 * 5 - salva todas as exps_docentes
		 * 6 - salva a quantidade de exps_relevante
		 * 7 - salva todas as exps_relevantes
		 * 8 - salva a quantidade de publicações
		 * 9 - salva todas as publicações 
		 * 
		 */
		return false;
	}

	public boolean load(String filename) {
		/*
		 * 1 - carrega todos os tipos primitivos
		 * 2 - carrega a quantidade de titulos
		 * 3 - carrega todos os titulos
		 * 4 - carrega a quantidade de exps_docentes
		 * 5 - carrega todas as exps_docentes
		 * 6 - carrega a quantidade de exps_relevante
		 * 7 - carrega todas as exps_relevantes
		 * 8 - carrega a quantidade de publicações
		 * 9 - carrega todas as publicações 
		 * 
		 */
		return false;
	}

	
}
