package projeto.models;

/**
 * Classe modelo para Experiencia Relevante que herda os atributos de Experiencia Profissional
 *  
 * @author Arthur, Gustavo, Marcelo, Rodolfo
 *
 */
public class ExpRelevante extends ExpProfissional {

/**
 * 
 * @param data_inicio
 * @param data_fim
 * @param descricao
 * @param instituicao
 * @param cidade
 * @param estado
 */
	
	public ExpRelevante(int data_inicio,int data_fim, String descricao, String instituicao,String cidade, String estado) {
		super(data_inicio, data_fim, descricao, instituicao, cidade, estado);

	}

}
