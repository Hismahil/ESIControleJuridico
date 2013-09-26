package br.uniotes.controle.juridico.advogado;

import br.dados.pessoa.fisica.PessoaFisica;

public class Advogado extends PessoaFisica{

	private static final long serialVersionUID = 1L;
	private int codAdv;
	private int nroOAB;

	public int getNroOAB() {
		return nroOAB;
	}

	public void setNroOAB(int nroOAB) {
		this.nroOAB = nroOAB;
	}

	public int getCodAdv() {
		return codAdv;
	}

	public void setCodAdv(int codAdv) {
		this.codAdv = codAdv;
	}
	
}
