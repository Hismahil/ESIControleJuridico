<<<<<<< HEAD
package br.unioeste.controle.juridico.control.cliente;

import br.unioeste.controle.juridico.model.cliente.ColCliente;
import br.uniotes.controle.juridico.cliente.Cliente;

public class UCManterClienteManager {

	private ColCliente colCli = new ColCliente();
	
	public Cliente retrieveClient(Integer codigo) throws Exception{
		return colCli.retrieveClient(codigo);
	}
}
=======
package br.unioeste.controle.juridico.control.cliente;

import br.unioeste.controle.juridico.model.cliente.ColCliente;
import br.uniotes.controle.juridico.cliente.Cliente;

public class UCManterClienteManager {

	private ColCliente colCli = new ColCliente();
	
	public Cliente retrieveClient(Integer codigo) throws Exception{
		return colCli.retrieveClient(codigo);
	}
}
>>>>>>> master
