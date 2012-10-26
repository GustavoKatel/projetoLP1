package projeto.models;

import java.util.GregorianCalendar;

/**
 * Classe modelo para Experiencia Docente que herda os atributos de Experiencia Profissional
 * 
 * @author Arthur, Gustavo, Marcelo, Rodolfo
 *
 */
public class ExpDocente extends ExpProfissional {

/**
 * 
 * @param data_inicio
 * @param data_fim
 * @param descricao
 * @param instituicao
 * @param cidade
 * @param estado
 */

	public ExpDocente(GregorianCalendar data_inicio,GregorianCalendar data_fim, String descricao, String instituicao,String cidade, String estado) {
		super(data_inicio, data_fim, descricao, instituicao, cidade, estado);

	}
	
}
