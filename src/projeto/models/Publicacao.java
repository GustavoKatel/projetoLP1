package projeto.models;

<<<<<<< HEAD
import java.util.LinkedList;

//Classe de manipulaÃ§Ã£o de dados de PublicaÃ§Ã£o
=======
import java.util.ArrayList;
/**
 * Classe modelo para implementar Publicações 
 * 
 * @author Arthur, Gustavo, Marcelo, Rodolfo
 *
 */
>>>>>>> a1d78ab90d8375e7cd3b88546f31337e831b4512
public class Publicacao {
	private String titulo;
	private LinkedList<String> autores;
	private String evento;
	private int ano;
	private String area;
	
	/**
	 * @param titulo titulo da publicação
	 * @param evento nome do evento na qual o trabalho foi publicado
	 * @param area area de interesse relativo ao trabalho
	 * @param ano ano em que a publicação foi feita
	 */
	
	public Publicacao(String titulo, String evento, String area,
			int ano) {
		super();
		this.titulo = titulo;
		this.autores = new LinkedList<String>();
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

	public LinkedList<String> getAutores() {
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
