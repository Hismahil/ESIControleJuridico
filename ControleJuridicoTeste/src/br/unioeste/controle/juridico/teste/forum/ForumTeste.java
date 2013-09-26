package br.unioeste.controle.juridico.teste.forum;

import br.unioeste.controle.juridico.model.forum.ColForum;
import br.uniotes.controle.juridico.forum.Forum;

public class ForumTeste {

	public static void main(String[] args) {
		ColForum colForum = new ColForum();
		
		Forum forum = null;
		
		try {
			forum = colForum.retrieveForum(1);
			
			System.out.println(forum.getId());
			System.out.println(forum.getCNPJ());
			System.out.println(forum.getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
