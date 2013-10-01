package br.unioeste.controle.juridico.controller.tipotramite;

import br.unioeste.controle.juridico.controller.IUCManterTipoTramiteManager;
import br.unioeste.controle.juridico.model.tipotramite.ColTipoTramite;
import br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite;

public class UCManterTipoTramiteManager implements IUCManterTipoTramiteManager {

	private ColTipoTramite colTipo = new ColTipoTramite();
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.tipotramite.IUCManterTipoTramiteManager#insertTipoTramite(br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite)
	 */
	@Override
	public TipoTramite insertTipoTramite(TipoTramite tipo) throws Exception{
		return colTipo.insertTipoTramite(tipo);
	}
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.tipotramite.IUCManterTipoTramiteManager#retrieveTipoTramite(java.lang.Integer)
	 */
	@Override
	public TipoTramite retrieveTipoTramite(Integer codTipoTramite) throws Exception{
		return colTipo.retrieveTipoTramite(codTipoTramite);
	}
}

