package br.uniotes.controle.juridico.processo.tipo;

import java.io.Serializable;

public class TipoProcesso implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
