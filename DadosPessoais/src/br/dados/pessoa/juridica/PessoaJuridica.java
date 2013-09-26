package br.dados.pessoa.juridica;

import br.dados.pessoa.Pessoa;

public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomeFantasia;
	private String CNPJ;
	
	public PessoaJuridica(){}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
