package br.dados.pessoa;

import java.io.Serializable;

import br.dados.endereco.EnderecoEspecifico;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	private EnderecoEspecifico endesp;
	private String telefone;
	private String nome;
	private String email;
	
	public Pessoa(){}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoEspecifico getEndesp() {
		return endesp;
	}

	public void setEndesp(EnderecoEspecifico endesp) {
		this.endesp = endesp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
