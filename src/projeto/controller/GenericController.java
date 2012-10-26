package projeto.controller;

import java.util.List;

public interface GenericController<E> {

	public boolean add(E obj);
	public boolean add(List<E> collection);
	public E get(int i);
	public int getSize();
	//
	public boolean save(String filename);
	public boolean load(String filename);
	
}
