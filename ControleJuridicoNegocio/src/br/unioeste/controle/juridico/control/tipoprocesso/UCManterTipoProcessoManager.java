<<<<<<< HEAD
package br.unioeste.controle.juridico.control.tipoprocesso;

import br.unioeste.controle.juridico.model.tipoprocesso.ColTipoProcesso;
import br.uniotes.controle.juridico.processo.tipo.TipoProcesso;

public class UCManterTipoProcessoManager {

	private ColTipoProcesso colTipo = new ColTipoProcesso();
	
	public TipoProcesso insertTipoProcesso(TipoProcesso tipo) throws Exception{
		return colTipo.insertTipoProcesso(tipo);
	}
	
	public TipoProcesso retrieveTipoProcesso(Integer codTipoProc) throws Exception{
		return colTipo.retrieveTipoProcesso(codTipoProc);
	}
}
=======
package br.unioeste.controle.juridico.control.tipoprocesso;

import br.unioeste.controle.juridico.model.tipoprocesso.ColTipoProcesso;
import br.uniotes.controle.juridico.processo.tipo.TipoProcesso;

public class UCManterTipoProcessoManager {

	private ColTipoProcesso colTipo = new ColTipoProcesso();
	
	public TipoProcesso insertTipoProcesso(TipoProcesso tipo) throws Exception{
		return colTipo.insertTipoProcesso(tipo);
	}
	
	public TipoProcesso retrieveTipoTramite(Integer codTipoProc) throws Exception{
		return colTipo.retrieveTipoTramite(codTipoProc);
	}
}
>>>>>>> master
