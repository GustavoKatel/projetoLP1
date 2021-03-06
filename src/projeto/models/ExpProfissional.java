package projeto.models;

/**
 * Classe abstrata de dados para modelos de Experiencia Profissional Docente e Relevante
 * 
 * @author Arthur, Gustavo, C.Marcelo, Rodolfo
 *
 */

public abstract class ExpProfissional {
	private int data_inicio;
	private int data_fim;
	private String descricao;
	private String instituicao;
	private String cidade;
	private String estado;
		
	/**
	 * @param data_inicio data do in�cio no emprego
	 * @param data_fim data final do funcionario no emprego
	 * @param descricao descri��o da atividade exercida no emprego
	 * @param instituicao empresa na qual o funcionario trabalhava
	 * @param cidade cidade no qual a empresa se localiza
	 * @param estado estado referente a cidade
	 */
	
	public ExpProfissional(int data_inicio,
			int data_fim, String descricao, String instituicao,
			String cidade, String estado) {
		super();
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.descricao = descricao;
		this.instituicao = instituicao;
		this.cidade = cidade;
		this.estado = estado;
	}


	public int getData_inicio() {
		return data_inicio;
	}


	public void setData_inicio(int data_inicio) {
		this.data_inicio = data_inicio;
	}


	public int getData_fim() {
		return data_fim;
	}


	public void setData_fim(int data_fim) {
		this.data_fim = data_fim;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		return "("+data_inicio+" - "+data_fim+") - "+descricao+" - "+instituicao+" - "+cidade+", "+estado;
	}
	
}
