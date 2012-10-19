package projeto.models;

import java.util.GregorianCalendar;

//Classe de abstrata de dados de Experiencia Profissional
public abstract class ExpProfissional {
	private GregorianCalendar data_inicio;
	private GregorianCalendar data_fim;
	private String descricao;
	private String instituicao;
	private String cidade;
	private String estado;
	
//Construtor da classe Experiencia Profissional
	public ExpProfissional(GregorianCalendar data_inicio,
			GregorianCalendar data_fim, String descricao, String instituicao,
			String cidade, String estado) {
		super();
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.descricao = descricao;
		this.instituicao = instituicao;
		this.cidade = cidade;
		this.estado = estado;
	}


	public GregorianCalendar getData_inicio() {
		return data_inicio;
	}


	public void setData_inicio(GregorianCalendar data_inicio) {
		this.data_inicio = data_inicio;
	}


	public GregorianCalendar getData_fim() {
		return data_fim;
	}


	public void setData_fim(GregorianCalendar data_fim) {
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
	
}
