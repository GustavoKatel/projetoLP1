package projeto.models;

/**
 *Classe modelo para T�tulos.
 * 
 * @author Arthur, Gustavo, Marcelo, Rodolfo
 * 
 */
public class Titulo {
	private int ano;
	private String formacao;
	private String curso;
	private String instituicao;
	private String cidade;
	private String estado;
	

	/**
	 * 
	 * @param ano ano em que foi concluído o curso
	 * @param formacao tipo de formação
	 * @param curso curso no qual foi concluído
	 * @param instituicao instituição na qual foi concluído o curso
	 * @param cidade cidade em que foi feito o curso
	 * @param estado estado a que a cidade pertence
	 */
	public Titulo(int ano, String formacao, String curso, String instituicao,
			String cidade, String estado) {
		super();
		this.ano = ano;
		this.formacao = formacao;
		this.curso = curso;
		this.instituicao = instituicao;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String toString()
	{
		return "("+ano+") "+formacao+" em "+curso+". "+instituicao+". "+cidade+", "+estado+".";
	}
	
	
}
