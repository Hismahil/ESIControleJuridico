package br.uniotes.controle.juridico.processo.tramite;

import java.io.Serializable;
import java.sql.Date;

import br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite;

public class TramiteProcesso implements Serializable{

	private static final long serialVersionUID = 1L;
	private String observacoes;
	private Date dtTramite;
	private TipoTramite tipo;
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public Date getDtTramite() {
		return dtTramite;
	}
	
	public void setDtTramite(Date dtTramite) {
		this.dtTramite = dtTramite;
	}
	
	public TipoTramite getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoTramite tipo) {
		this.tipo = tipo;
	}
	
	
}
