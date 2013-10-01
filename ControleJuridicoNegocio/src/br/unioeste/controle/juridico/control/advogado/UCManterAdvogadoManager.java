package br.unioeste.controle.juridico.control.advogado;

import br.unioeste.controle.juridico.model.advogado.ColAdvogado;
import br.uniotes.controle.juridico.advogado.Advogado;

public class UCManterAdvogadoManager {

	private ColAdvogado colAdv = new ColAdvogado();
	
	public Advogado retrieveAdvogado(Integer codigo) throws Exception{
		return colAdv.retrieveAdvogado(codigo);
	}
}
