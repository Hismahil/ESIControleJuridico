package br.unioeste.controle.juridico.teste.db;

import br.unioeste.controle.juridico.db.connection.DataBaseConnection;

public class DataBaseTeste {

	public static void main(String[] args) {
		DataBaseConnection.getInstance().teste();
	}

}
