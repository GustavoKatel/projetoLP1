package projeto.models;

import java.util.GregorianCalendar;

public class ExpDocente extends ExpProfissional {

	public ExpDocente(GregorianCalendar data_inicio,GregorianCalendar data_fim, String descricao, String instituicao,String cidade, String estado) {
		super(data_inicio, data_fim, descricao, instituicao, cidade, estado);

	}
	
}
