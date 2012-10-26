package projeto.controller;

import java.util.LinkedList;
import java.util.List;

import projeto.models.Titulo;

public class TituloController implements GenericController<Titulo> {

	private LinkedList<Titulo> titulos;
	
	public TituloController()
	{
		titulos = new LinkedList<Titulo>();
	}
	
	@Override
	public boolean add(Titulo obj) {
		return titulos.add(obj);
	}

	@Override
	public boolean add(List<Titulo> collection) {
		return titulos.addAll(collection);
	}

	@Override
	public Titulo get(int i) {
		if(i>=titulos.size())
			return null;
		return titulos.get(i);
	}

	@Override
	public int getSize() {
		return titulos.size();
	}

	@Override
	public boolean save(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean load(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

}
