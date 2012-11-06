package projeto.models;

/**
 * Classe modelo para Experiencia Relevante que herda os atributos de Experiencia Profissional
 *  
 * @author Arthur, Gustavo, C.Marcelo, Rodolfo
 *
 */
public class ExpRelevante extends ExpProfissional {

/**
 * 
 * @param data_inicio data de inicio da experiencia a ser cadastrada
 * @param data_fim data de fim da experiencia a ser cadastrada
 * @param descricao descricao das atividades exercidas
 * @param instituicao local aonde o trabalho foi feito
 * @param cidade cidade aonde se localiza a instituicao
 * @param estado estado referente a cidade
 */
	
	public ExpRelevante(int data_inicio,int data_fim, String descricao, String instituicao,String cidade, String estado) {
		super(data_inicio, data_fim, descricao, instituicao, cidade, estado);

	}

}
