package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Loja;
import com.industria.roupa.repositories.LojaRepository;

public class LojaBiz {
	
	public Mensagem msg;

	private LojaRepository roupaRepository;

	public LojaBiz(LojaRepository lojaRepository) {
		msg = new Mensagem();
	}

	public Boolean Validade(Loja loja) {

		boolean result = true;
		if (lojaRepository.existsById(loja.getIdloja())) {
			msg.mensagens.add("O nome da Loja não existe");
			result = false;
		}
		
		if (Credito.getPreco() < 0) {
			msg.mensagens.add( "O Credito não pode ser negativo");
			result = false;
		}
		return result;
	
	

	}
}
