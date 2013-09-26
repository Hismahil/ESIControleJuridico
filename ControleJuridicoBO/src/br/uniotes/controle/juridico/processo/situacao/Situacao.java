package br.uniotes.controle.juridico.processo.situacao;

import java.io.Serializable;

public class Situacao implements Serializable{

	private static final long serialVersionUID = 1L;
	private String situacao;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
