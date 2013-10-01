package br.unioeste.controle.juridico.control.tipotramite;

import br.unioeste.controle.juridico.model.tipotramite.ColTipoTramite;
import br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite;

public class UCManterTipoTramiteManager {

	private ColTipoTramite colTipo = new ColTipoTramite();
	
	public TipoTramite insertTipoTramite(TipoTramite tipo) throws Exception{
		return colTipo.insertTipoTramite(tipo);
	}
	
	public TipoTramite retrieveTipoTramite(Integer codTipoTramite) throws Exception{
		return colTipo.retrieveTipoTramite(codTipoTramite);
	}
}
