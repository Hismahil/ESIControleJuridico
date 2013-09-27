package br.unioeste.controle.juridico.control.forum;

import br.unioeste.controle.juridico.model.forum.ColForum;
import br.uniotes.controle.juridico.forum.Forum;

public class UCManterForumManager {

	private ColForum colForum = new ColForum();
	
	public Forum retrieveForum(int codForum) throws Exception{
		return colForum.retrieveForum(codForum);
	}
}
