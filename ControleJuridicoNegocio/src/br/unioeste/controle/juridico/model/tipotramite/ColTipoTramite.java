package br.unioeste.controle.juridico.model.tipotramite;

import java.sql.ResultSet;

import br.unioeste.controle.juridico.db.connection.DataBaseConnection;
import br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite;

public class ColTipoTramite {

	/**
	 * <h3><b>Insere dados do tipo de trâmite</b></h3>
	 * @param tipo
	 * @return
	 * @throws Exception
	 */
	public TipoTramite insertTipoTramite(TipoTramite tipo) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tipotramite(tipo) VALUES ('" + tipo.getTipo() + "')");
		
		DataBaseConnection.getInstance().execute(sql);
		
		tipo.setCodTipoTramite(getLastID());
		
		return tipo;
	}
	
	/**
	 * <h3><b>Apenas verifica o código da ultima inserção</b></h3><br/>
	 * @return <code>Código do ultimo registro</code>
	 * @throws Exception 
	 */
	private int getLastID() throws Exception{
		
		StringBuilder sql = new StringBuilder();
		int id = 0;
		
		sql.append("SELECT MAX(codTipoTramite) FROM tipotramite");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		while(rs.next()){
			id = rs.getInt(1);
		}
		
		return id;
	}
	/**
	 * <h3><b>Retorna dados do Tipo de trâmite</b></h3>
	 * @param codTipoTramite
	 * @return
	 * @throws Exception
	 */
	public TipoTramite retrieveTipoTramite(Integer codTipoTramite) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tipotramite WHERE codTipoTramite = " + codTipoTramite + "");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		TipoTramite tipo = new TipoTramite();
		
		while(rs.next()){
			tipo.setCodTipoTramite(rs.getInt(1));
			tipo.setTipo(rs.getString(2));
		}
		
		return tipo;
	}
}
