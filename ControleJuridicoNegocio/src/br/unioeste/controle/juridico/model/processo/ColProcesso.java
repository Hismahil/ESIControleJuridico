package br.unioeste.controle.juridico.model.processo;

import java.sql.ResultSet;

import br.unioeste.controle.juridico.common.connection.DataBaseConnection;
import br.uniotes.controle.juridico.advogado.Advogado;
import br.uniotes.controle.juridico.cliente.Cliente;
import br.uniotes.controle.juridico.forum.Forum;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.tipo.TipoProcesso;

public class ColProcesso {

	/**
	 * <h3><b>insere um processo (Falta as valida��es que o professor pediu)</b></h3>
	 * @param proc
	 * @return
	 * @throws Exception
	 */
	public Processo insertProcesso(Processo proc) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO processo VALUES ('" + proc.getDtAbertura() + "','"
				+ proc.getDescricao() + "',"
				+ proc.getTipo().getCodTipoProcesso() + ","
				+ proc.getForum().getId() + ","
				+ proc.getCliente().getCodCli() + ","
				+ proc.getSituacao() + ","
				+ proc.getNroProcesso() + ","
				+ proc.getAdvogado().getCodAdv() + ")");
		
		DataBaseConnection.getInstance().execute(sql);
		
		proc.setCodProc(getLastID());
		
		return proc;
	}
	
	/**
	 * <h3><b>Apenas verifica o c�digo da ultima inser��o</b></h3><br/>
	 * @return <code>C�digo do ultimo registro</code>
	 * @throws Exception 
	 */
	private int getLastID() throws Exception{
		
		StringBuilder sql = new StringBuilder();
		int id = 0;
		
		sql.append("SELECT MAX(codProc) FROM processo");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		while(rs.next()){
			id = rs.getInt(1);
		}
		
		return id;
	}
	
	/**
	 * <h3><b>Retorna dados do processo</b></h3>
	 * @param codProc
	 * @return
	 * @throws Exception
	 */
	public Processo retrieveProcesso(Integer codProc) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM processo WHERE codProc = " + codProc);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = new Processo();
		TipoProcesso tipo = new TipoProcesso();
		Forum forum = new Forum();
		Cliente cliente = new Cliente();
		Advogado adv = new Advogado();
		
		while(rs.next()){
			proc.setDtAbertura(rs.getString("dtAbertura"));
			proc.setDescricao(rs.getString("descricao"));
			proc.setSituacao(rs.getInt("situacao"));
			proc.setNroProcesso(rs.getString("nroProcesso"));
			
			tipo.setCodTipoProcesso(rs.getInt("codTipoProc"));
			proc.setTipo(tipo);
			
			forum.setCodForum(rs.getInt("codForum"));
			proc.setForum(forum);
			
			cliente.setCodCli(rs.getInt("codCli"));
			proc.setCliente(cliente);
			
			adv.setCodAdv(rs.getInt("codAdv"));
			proc.setAdvogado(adv);
		}
		
		return proc;
	}
}
