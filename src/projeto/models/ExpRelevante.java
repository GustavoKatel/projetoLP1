package projeto.models;

import java.util.GregorianCalendar;

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
	
	public ExpRelevante(GregorianCalendar data_inicio,GregorianCalendar data_fim, String descricao, String instituicao,String cidade, String estado) {
		super(data_inicio, data_fim, descricao, instituicao, cidade, estado);

	}

}
