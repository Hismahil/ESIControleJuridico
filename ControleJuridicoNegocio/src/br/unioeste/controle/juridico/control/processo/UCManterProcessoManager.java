<<<<<<< HEAD
package br.unioeste.controle.juridico.control.processo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.unioeste.controle.juridico.control.tramite.UCManterTramiteManager;
import br.unioeste.controle.juridico.exception.NoMoreProcess;
import br.unioeste.controle.juridico.exception.NoUpdateProcess;
import br.unioeste.controle.juridico.model.processo.ColProcesso;
import br.unioeste.controle.juridico.model.tramite.ColTramite;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;
import br.uniotes.controle.juridico.processo.tramite.tipo.TipoTramite;

public class UCManterProcessoManager {

	private ColProcesso colProc = new ColProcesso();
	private SimpleDateFormat sdf;
	/**
	 * <h3><b>Insere processo</b></h3><br/>
	 * @param proc <code>Processo</code><br/>
	 * @return <code>Processo</code>
	 * @throws Exception
	 */
	public Processo insertProcesso(Processo proc) throws Exception{
		if(isInvalidate(proc)) 
			throw new NoMoreProcess("client can not enter the process", "Process equals");
		
		if(isLawyerOverflow(proc))
			throw new NoMoreProcess("Lawyer is full of process", "Can not enter the process");
		
		proc = colProc.insertProcesso(proc);
		
		createTramiteAbertura(proc);
		
		return proc; 
	}
	
	public Processo retrieveProcesso(Integer codProc) throws Exception{
		return colProc.retrieveProcesso(codProc);
	}
	
	public List<Processo> retrieveAllProcesso() throws Exception{
		return colProc.retrieveAllProcesso();
	}
	
	public Processo retrieveProcessoOfNro(String nroProcesso) throws Exception{
		return colProc.retrieveProcessoOfNro(nroProcesso);
	}
	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv) throws Exception{
		return colProc.retrieveAllProcessoAdvogado(codAdv);
	}
	
	public List<Processo> retrieveAllProcessoCliente(Integer codCli) throws Exception{
		return colProc.retrieveAllProcessoCliente(codCli);
	}
	
	public Processo updateProcesso(Processo newProc,Processo oldProc) throws Exception{
		if(oldProc.getSituacao() == 0){
			ColTramite colTramite = new ColTramite();
			TramiteProcesso tramite = new TramiteProcesso();
			
			tramite = colTramite.retrieveTramiteProcesso(oldProc.getDtAbertura());
			
			if(tramite.getTipo().getTipo().equals("Abertura")){
				
				if(newProc.getSituacao() != oldProc.getSituacao()){
					sdf = new SimpleDateFormat("dd/MM/yyyy");  
					
					UCManterTramiteManager manager = new UCManterTramiteManager();
					
					tramite = new TramiteProcesso();
					tramite.setDtTramite(sdf.format( new Date( System.currentTimeMillis() ) ));
					tramite.setObservacoes("Lançamento da situação");
					
					TipoTramite tipo = new TipoTramite();
					tipo.setTipo(getSituacao(newProc.getSituacao()));
					tramite.setTipo(tipo);
					
					tramite.setProc(oldProc);
					
					tramite = manager.insertTramiteProcesso(tramite);
				}
				
				return colProc.updateProcesso(newProc, oldProc);
			}
			else 
				throw new NoUpdateProcess("Processo não pode ser atualizado", 
						"O Trâmite do processo não é Abertura");
		}
		else
			throw new NoUpdateProcess("Processo não pode ser atualizado", 
					"Situação do Processo não é de Aberto");
		
	}
	/**
	 * <h3><b>Verifica se o cliente está tentando entrar com o mesmo processo no mesmo mês</b></h3><br/>
	 * @param proc <code>Processo</code><br/>
	 * @return <code>true</code> ou <code>false</code>
	 * @throws Exception
	 */
	private boolean isInvalidate(Processo proc) throws Exception{
		List<Processo> lista = retrieveAllProcessoCliente(proc.getCliente().getCodCli());
		
		Date now = new Date(System.currentTimeMillis());
		int m = now.getMonth() + 1;
		
		for(Processo p : lista){
			if(proc.getTipo().getTipo().equals(p.getTipo().getTipo())){
				Date d = new Date(p.getDtAbertura());
				if(d.getDate() == m) return true;
			}
		}
		
		return false;
	}
	/**
	 * <h3><b>Verifica se o advogado já possui 3 processo com a siatuação 0 (Aberto)</b></h3><br/>
	 * @param proc <code>Processo</code><br/>
	 * @return <code>true</code> ou <code>false</code>
	 * @throws Exception
	 */
	private boolean isLawyerOverflow(Processo proc) throws Exception{
		List<Processo> list = retrieveAllProcessoAdvogado(proc.getAdvogado().getCodAdv());
		int i = 0;
		
		for(Processo p : list){
			if(p.getSituacao() == 0) i++;
			
			if(i == 3) return true;
		}
		
		return false;
	}
	
	/**
	 * <h3><b>Cria o trâmite de abertura do processo</b></h3><br/>
	 * @param proc <code>Processo</code>
	 * @throws Exception
	 */
	private void createTramiteAbertura(Processo proc) throws Exception{
		sdf = new SimpleDateFormat("dd/MM/yyyy");  
		
		UCManterTramiteManager manager = new UCManterTramiteManager();
		
		TramiteProcesso tramite = new TramiteProcesso();
		tramite.setDtTramite(sdf.format( new Date( System.currentTimeMillis() ) ));
		tramite.setObservacoes("Criação do processo no escritório");
		
		TipoTramite tipo = new TipoTramite();
		tipo.setTipo("Abertura");
		tramite.setTipo(tipo);
		
		tramite.setProc(proc);
		
		tramite = manager.insertTramiteProcesso(tramite);
	}
	
	private String getSituacao(Integer situacao){
		switch(situacao){
			case 0: return "Aberto";
			case 1: return "Em Julgamento";
			case 2: return "Julgado";
			case 3: return "Cancelado";
		}
		return null;
	}
}
=======
package br.unioeste.controle.juridico.control.processo;

import java.util.List;

import br.unioeste.controle.juridico.model.processo.ColProcesso;
import br.uniotes.controle.juridico.processo.Processo;

public class UCManterProcessoManager {

	private ColProcesso colProc = new ColProcesso();
	
	public Processo insertProcesso(Processo proc) throws Exception{
		return colProc.insertProcesso(proc);
	}
	
	public Processo retrieveProcesso(Integer codProc) throws Exception{
		return colProc.retrieveProcesso(codProc);
	}
	
	public List<Processo> retrieveAllProcesso() throws Exception{
		return colProc.retrieveAllProcesso();
	}
	
	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv) throws Exception{
		return colProc.retrieveAllProcessoAdvogado(codAdv);
	}
	
	public List<Processo> retrieveAllProcessoCliente(Integer codCli) throws Exception{
		return colProc.retrieveAllProcessoCliente(codCli);
	}
	
	public Processo updateProcesso(Processo newProc,Processo oldProc) throws Exception{
		return colProc.updateProcesso(newProc, oldProc);
	}
}
>>>>>>> master
