<<<<<<< HEAD
package br.unioeste.controle.juridico.control.tramite;

import java.util.List;

import br.unioeste.controle.juridico.exception.NoPending;
import br.unioeste.controle.juridico.model.tramite.ColTramite;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;

public class UCManterTramiteManager {

	private ColTramite colTramite = new ColTramite();
	
	public TramiteProcesso insertTramiteProcesso(TramiteProcesso tramite) throws Exception{
		if(tramite.getProc().getSituacao() == 0 || tramite.getProc().getSituacao() == 1){
			return colTramite.insertTramiteProcesso(tramite);
		}
		else
			throw new NoPending("N�o pode ser adicionado novo tr�mite", 
					"A situa��o do processo n�o permite");
		
	}
	
	public TramiteProcesso retrieveTramiteProcesso(String dataTramite) throws Exception{
		return colTramite.retrieveTramiteProcesso(dataTramite);
	}
	
	public List<TramiteProcesso> retrieveAll(Integer codProc) throws Exception{
		return colTramite.retrieveAll(codProc);
	}
}
=======
package br.unioeste.controle.juridico.control.tramite;

import br.unioeste.controle.juridico.model.tramite.ColTramite;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;

public class UCManterTramiteManager {

	private ColTramite colTramite = new ColTramite();
	
	public TramiteProcesso insertTramiteProcesso(TramiteProcesso tramite) throws Exception{
		return colTramite.insertTramiteProcesso(tramite);
	}
	
	public TramiteProcesso retrieveTramiteProcesso(String dataTramite) throws Exception{
		return colTramite.retrieveTramiteProcesso(dataTramite);
	}
	
	
}
>>>>>>> master
