package br.unioeste.controle.juridico.model.tramite;

import java.sql.ResultSet;

import br.unioeste.controle.juridico.common.connection.DataBaseConnection;
import br.unioeste.controle.juridico.model.tipotramite.ColTipoTramite;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;
import br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite;

public class ColTramite {

	/**
	 * <h3><b>Insere dados de um Tramite e seu tipo</b></h3>
	 * @param tramite
	 * @return
	 * @throws Exception
	 */
	public TramiteProcesso insertTramiteProcesso(TramiteProcesso tramite) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		ColTipoTramite colTipo = new ColTipoTramite();
		tramite.setTipo(colTipo.insertTipoTramite(tramite.getTipo()));
		
		sql.append("INSERT INTO tramiteprocesso VALUES ("+tramite.getProc().getCodProc()+ ","
				+ tramite.getTipo().getCodTipoTramite() + ",'"
				+ tramite.getObservacoes() + "','"
				+ tramite.getDtTramite() + "')");
		
		DataBaseConnection.getInstance().executeSQL(sql);
		
		return retrieveTramiteProcesso(tramite.getDtTramite());
	}
	/**
	 * <h3><b>Retorna dados de um tr�mite e seu tipo</b></h3>
	 * @param dataTramite
	 * @return
	 * @throws Exception
	 */
	public TramiteProcesso retrieveTramiteProcesso(String dataTramite) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tramiteprocesso WHERE dtTramite = '"+ dataTramite + "'");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		TramiteProcesso tramite = new TramiteProcesso();
		TipoTramite tipo = new TipoTramite();
		Processo proc = new Processo();
		
		while(rs.next()){
			tramite.setDtTramite(rs.getString("dtTramite"));
			tramite.setObservacoes(rs.getString("observacoes"));
			
			proc.setCodProc(rs.getInt("codProc"));
			tipo.setCodTipoTramite(rs.getInt("codTipoTramite"));
			tramite.setProc(proc);
			tramite.setTipo(tipo);
		}
		
		ColTipoTramite colTipo = new ColTipoTramite();
		
		tramite.setTipo(colTipo.retrieveTipoTramite(tipo.getCodTipoTramite()));
		
		return tramite;
	}
}
