package br.unioeste.controle.juridico.teste.tipoprocesso;

import br.unioeste.controle.juridico.model.tipoprocesso.ColTipoProcesso;
import br.uniotes.controle.juridico.processo.tipo.TipoProcesso;

public class TipoProcessoTeste {

	public static void main(String[] args) {
		ColTipoProcesso colTipo = new ColTipoProcesso();
		TipoProcesso tipo = new TipoProcesso();
		
		tipo.setTipo("Especial Civel");
		
		try {
			tipo = colTipo.insertTipoProcesso(tipo);
			
			tipo = colTipo.retrieveTipoTramite(tipo.getCodTipoProcesso());
			
			System.out.println(tipo.getCodTipoProcesso());
			System.out.println(tipo.getTipo());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
