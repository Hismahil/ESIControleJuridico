package br.uniotes.controle.juridico.processo.tramite.tipo;

import java.io.Serializable;

public class TipoTramite implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
