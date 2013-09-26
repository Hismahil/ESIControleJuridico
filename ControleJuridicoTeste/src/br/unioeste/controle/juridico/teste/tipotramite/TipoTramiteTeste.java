package br.unioeste.controle.juridico.teste.tipotramite;

import br.unioeste.controle.juridico.model.tipotramite.ColTipoTramite;
import br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite;

public class TipoTramiteTeste {

	public static void main(String[] args) {
		ColTipoTramite colTipo = new ColTipoTramite();
		TipoTramite tipo = new TipoTramite();
		
		tipo.setTipo("Abertura");
		
		try {
			tipo = colTipo.insertTipoTramite(tipo);
			
			tipo = colTipo.retrieveTipoTramite(tipo.getCodTipoTramite());
			
			System.out.println(tipo.getCodTipoTramite());
			System.out.println(tipo.getTipo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
