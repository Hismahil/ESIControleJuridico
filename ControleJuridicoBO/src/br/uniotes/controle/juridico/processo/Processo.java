package br.uniotes.controle.juridico.processo;

import java.io.Serializable;
import java.sql.Date;

import br.uniotes.controle.juridico.advogado.Advogado;
import br.uniotes.controle.juridico.cliente.Cliente;
import br.uniotes.controle.juridico.forum.Forum;
import br.uniotes.controle.juridico.processo.situacao.Situacao;
import br.uniotes.controle.juridico.processo.tipo.TipoProcesso;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;

public class Processo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nroProcesso;
	private Date dtAbertura;
	private String descricao;
	private Forum forum;
	private Cliente cliente;
	private Advogado advogado;
	private Situacao situacao;
	private TipoProcesso tipo;
	private TramiteProcesso tramite;
	
	public String getNroProcesso() {
		return nroProcesso;
	}
	
	public void setNroProcesso(String nroProcesso) {
		this.nroProcesso = nroProcesso;
	}
	
	public Date getDtAbertura() {
		return dtAbertura;
	}
	
	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public TipoProcesso getTipo() {
		return tipo;
	}

	public void setTipo(TipoProcesso tipo) {
		this.tipo = tipo;
	}

	public TramiteProcesso getTramite() {
		return tramite;
	}

	public void setTramite(TramiteProcesso tramite) {
		this.tramite = tramite;
	}

	
}
