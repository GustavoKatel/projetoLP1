package projeto.models;

/**
 * Classe modelo para implementar Publicações 
 * 
 * @author Arthur, Gustavo, C.Marcelo, Rodolfo
 *
 */
public class Publicacao {
	private String titulo;
	private String autores;
	private String evento;
	private int ano;
	private String area;
	
	/**
	 * @param titulo titulo da publicação
	 * @param evento nome do evento na qual o trabalho foi publicado
	 * @param area area de interesse relativo ao trabalho
	 * @param ano ano em que a publicação foi feita
	 */
	
	public Publicacao(String titulo, String autores, String evento, String area,
			int ano) {
		super();
		this.area = area;
		this.titulo = titulo;
		this.autores = autores;
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

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
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
	public String toString()
	{
		return "("+ano+") "+titulo+" - "+autores+" , "+evento+" . "+area+" . ";
	}
}
