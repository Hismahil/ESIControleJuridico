package br.unioeste.controle.juridico.model.processo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.controle.juridico.db.connection.DataBaseConnection;
import br.unioeste.controle.juridico.model.advogado.ColAdvogado;
import br.unioeste.controle.juridico.model.cliente.ColCliente;
import br.unioeste.controle.juridico.model.forum.ColForum;
import br.unioeste.controle.juridico.model.tipoprocesso.ColTipoProcesso;
import br.uniotes.controle.juridico.advogado.Advogado;
import br.uniotes.controle.juridico.cliente.Cliente;
import br.uniotes.controle.juridico.forum.Forum;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.tipo.TipoProcesso;

public class ColProcesso {

	/**
	 * <h3><b>insere um processo (Falta as validações que o professor pediu)</b></h3>
	 * @param proc <code>Novo processo</code>
	 * @return <code>Processo com o código</code>
	 * @throws Exception
	 */
	public Processo insertProcesso(Processo proc) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO processo(dtAbertura, descricao, codTipoProc, codForum, codCli, situacao, nroProcesso, codAdv) VALUES ('" + proc.getDtAbertura() + "','"
				+ proc.getDescricao() + "',"
				+ proc.getTipo().getCodTipoProcesso() + ","
				+ proc.getForum().getCodForum() + ","
				+ proc.getCliente().getCodCli() + ","
				+ proc.getSituacao() + ","
				+ proc.getNroProcesso() + ","
				+ proc.getAdvogado().getCodAdv() + ")");
		
		DataBaseConnection.getInstance().execute(sql);
		
		proc.setCodProc(getLastID());
		
		return proc;
	}
	
	/**
	 * <h3><b>Apenas verifica o código da ultima inserção</b></h3><br/>
	 * @return <code>Código do ultimo registro</code>
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
	 * @param codProc <code>Código do processo sem ser o numero</code>
	 * @return <code>Processo</code>
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
			proc.setCodProc(rs.getInt("codProc"));
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
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		proc.setTipo(colTipo.retrieveTipoProcesso(proc.getTipo().getCodTipoProcesso()));
		
		ColForum colForum = new ColForum();
		proc.setForum(colForum.retrieveForum(proc.getForum().getCodForum()));
		
		ColCliente colCliente = new ColCliente();
		proc.setCliente(colCliente.retrieveClient(proc.getCliente().getCodCli()));
		
		ColAdvogado colAdv = new ColAdvogado();
		proc.setAdvogado(colAdv.retrieveAdvogado(proc.getAdvogado().getCodAdv()));
		
		return proc;
	}
	
	/**
	 * <h3><b>Retorna dados do processo</b></h3>
	 * @param codProc <code>Código do processo sem ser o numero</code>
	 * @return <code>Processo</code>
	 * @throws Exception
	 */
	public Processo retrieveProcessoOfNro(String nroProcesso) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM processo WHERE nroProcesso = " + nroProcesso);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = new Processo();
		TipoProcesso tipo = new TipoProcesso();
		Forum forum = new Forum();
		Cliente cliente = new Cliente();
		Advogado adv = new Advogado();
		
		while(rs.next()){
			proc.setCodProc(rs.getInt("codProc"));
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
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		proc.setTipo(colTipo.retrieveTipoProcesso(proc.getTipo().getCodTipoProcesso()));
		
		ColForum colForum = new ColForum();
		proc.setForum(colForum.retrieveForum(proc.getForum().getCodForum()));
		
		ColCliente colCliente = new ColCliente();
		proc.setCliente(colCliente.retrieveClient(proc.getCliente().getCodCli()));
		
		ColAdvogado colAdv = new ColAdvogado();
		proc.setAdvogado(colAdv.retrieveAdvogado(proc.getAdvogado().getCodAdv()));
		
		return proc;
	}
	
	
	/**
	 * <h3><b>Retorna todos os processos</b></h3>
	 * @return <code>List<Process></code>
	 * @throws Exception
	 */
	public List<Processo> retrieveAllProcesso() throws Exception{
		StringBuilder sql = new StringBuilder();
		List<Processo> lista = new ArrayList<Processo>();
		
		sql.append("SELECT * FROM processo");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = null;
		TipoProcesso tipo = null;
		Forum forum = null;
		Cliente cliente = null;
		Advogado adv = null;
		
		while(rs.next()){
			proc = new Processo();
			tipo = new TipoProcesso();
			forum = new Forum();
			cliente = new Cliente();
			adv = new Advogado();
			
			proc.setCodProc(rs.getInt("codProc"));
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
			
			lista.add(proc);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		
		for(Processo p : lista){
			p.setTipo(colTipo.retrieveTipoProcesso(p.getTipo().getCodTipoProcesso()));
		}
		
		return lista;
	}
	
	/**
	 * <h3><b>Retorna todos os processos de um advogado</b></h3>
	 * @param codAdv <code>Código do Advogado</code>
	 * @return <code>List<Processo></code>
	 * @throws Exception
	 */
	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv) throws Exception{
		StringBuilder sql = new StringBuilder();
		List<Processo> lista = new ArrayList<Processo>();
		
		sql.append("SELECT * FROM processo WHERE codAdv = "+codAdv);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = null;
		TipoProcesso tipo = null;
		Forum forum = null;
		Cliente cliente = null;
		Advogado adv = null;
		
		while(rs.next()){
			proc = new Processo();
			tipo = new TipoProcesso();
			forum = new Forum();
			cliente = new Cliente();
			adv = new Advogado();
			
			proc.setCodProc(rs.getInt("codProc"));
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
			
			lista.add(proc);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		
		for(Processo p : lista){
			p.setTipo(colTipo.retrieveTipoProcesso(p.getTipo().getCodTipoProcesso()));
		}
		
		return lista;
	}
	
	/**
	 * <h3><b>Retorna todos os processos de um cliente</b></h3>
	 * @param codCli <code>Código do cliente</code>
	 * @return <code>List<Processo></code>
	 * @throws Exception
	 */
	public List<Processo> retrieveAllProcessoCliente(Integer codCli) throws Exception{
		StringBuilder sql = new StringBuilder();
		List<Processo> lista = new ArrayList<Processo>();
		
		sql.append("SELECT * FROM processo WHERE codCli = "+codCli);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = null;
		TipoProcesso tipo = null;
		Forum forum = null;
		Cliente cliente = null;
		Advogado adv = null;
		
		while(rs.next()){
			proc = new Processo();
			tipo = new TipoProcesso();
			forum = new Forum();
			cliente = new Cliente();
			adv = new Advogado();
			
			proc.setCodProc(rs.getInt("codProc"));
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
			
			lista.add(proc);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		
		for(Processo p : lista){
			p.setTipo(colTipo.retrieveTipoProcesso(p.getTipo().getCodTipoProcesso()));
		}
		
		return lista;
	}
	
	public Processo updateProcesso(Processo newProc,Processo oldProc) throws Exception{
		
		atualizarProcesso("situacao", newProc.getSituacao().toString(), oldProc.getSituacao().toString(),true);
		atualizarProcesso("descricao", newProc.getDescricao(), oldProc.getDescricao(),false);
		
		return newProc;
	}
	
	/**
	 * <h3><b>Altera dados de uma tabela</b></h3><br/>
	 * @param column <code>Coluna que será modificada</code><br/>
	 * @param newValue <code>Novo valor</code><br/>
	 * @param oldValue <code>Valor antigo</code><br/>
	 * @throws Exception 
	 */
	public void atualizarProcesso(String column,String newValue,String oldValue,boolean isInt) throws Exception{
		
		StringBuilder sql = new StringBuilder(); 
		if(isInt)
			sql.append("UPDATE processo SET " + column + "=" + newValue + " WHERE " + column + "=" + oldValue + ";");
		else
			sql.append("UPDATE processo SET " + column + "='" + newValue + "' WHERE " + column + "='" + oldValue + "';");
		
		DataBaseConnection.getInstance().execute(sql);
	}
}
