package br.dados.endereco;

public class EnderecoEspecifico {
	
	private Integer nroApto;
	private String complemento;
	private Endereco endereco;
	
	public EnderecoEspecifico(){}
	
	public Integer getNroApto() {
		return nroApto;
	}
	
	public void setNroApto(Integer nroApto) {
		this.nroApto = nroApto;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
