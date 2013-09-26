package br.unioeste.controle.juridico.teste.cliente;

import br.dados.pessoa.fisica.PessoaFisica;
import br.dados.pessoa.juridica.PessoaJuridica;
import br.unioeste.controle.juridico.model.cliente.ColCliente;
import br.uniotes.controle.juridico.cliente.Cliente;

public class ClienteTeste {

	public static void main(String[] args) {
		ColCliente colCliente = new ColCliente();
		Cliente cliente = null;
		
		try {
			cliente = colCliente.retrieveClient(2);
			
			System.out.println(cliente.getCodCli());
			
			if(cliente.getPessoa() instanceof PessoaFisica){
				PessoaFisica p = (PessoaFisica) cliente.getPessoa();
				
				System.out.println(p.getCPF());
				System.out.println(p.getNome());
				System.out.println(p.getSobreNome());
			}
			else{
				PessoaJuridica p = (PessoaJuridica) cliente.getPessoa();
				
				System.out.println(p.getNome());
				System.out.println(p.getNomeFantasia());
				System.out.println(p.getCNPJ());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
