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
