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
