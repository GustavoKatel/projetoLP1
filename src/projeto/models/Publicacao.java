package projeto.models;

import java.util.ArrayList;

//Classe de manipula��o de dados de Publica��o
public class Publicacao {
	private String titulo;
	private ArrayList<String> autores;
	private String evento;
	private int ano;
	private String area;

//Construtor da classe Publica��o
	public Publicacao(String titulo, String evento, String area,
			int ano) {
		super();
		this.titulo = titulo;
		this.autores = new ArrayList<String>();
		this.evento = evento;
		this.ano = ano;
	}
	public String getArea(){
		return area;
	}
	
	public void setArea(String area){
		this.area = area;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void addAutor(String autor) {
		if (autores != null){
			autores.add(autor);
		}
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
}