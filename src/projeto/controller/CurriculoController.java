package projeto.controller;

import java.util.LinkedList;
import java.util.List;

import projeto.models.Curriculo;

public class CurriculoController implements GenericController<Curriculo> {

	private static LinkedList<Curriculo> curriculos = null;
	
	public CurriculoController()
	{
		if(curriculos==null)
			curriculos = new LinkedList<Curriculo>();
	}
	
	@Override
	public boolean add(Curriculo obj) {
		return curriculos.add(obj);
	}

	@Override
	public boolean add(List<Curriculo> collection) {
		return curriculos.addAll(collection);
	}
	
	@Override
	public Curriculo get(int i) {
		if(i>curriculos.size())
			return null;
		return curriculos.get(i);
	}

	@Override
	public int getSize()
	{
		return curriculos.size();
	}
	
	@Override
	public boolean save(String filename) {
		return false;
	}

	@Override
	public boolean load(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
