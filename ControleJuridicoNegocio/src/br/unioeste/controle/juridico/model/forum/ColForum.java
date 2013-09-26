package br.unioeste.controle.juridico.model.forum;

import java.sql.ResultSet;

import br.unioeste.controle.juridico.db.connection.DataBaseConnection;
import br.uniotes.controle.juridico.forum.Forum;

public class ColForum {

	/**
	 * <h3><b>Retorna dados do Forum</b></h3>
	 * @param codForum código do forum
	 * @return Forum
	 * @throws Exception
	 */
	public Forum retrieveForum(int codForum) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM forum WHERE codForum = " + codForum);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Forum forum = new Forum();
		
		while(rs.next()){
			
			forum.setId(rs.getInt("codForum"));
			forum.setNome(rs.getString("nome"));
			forum.setCNPJ(rs.getString("cnpj"));
		}
		
		return forum;
	}
}
