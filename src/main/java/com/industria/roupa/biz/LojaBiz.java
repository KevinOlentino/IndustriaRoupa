package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Loja;
<<<<<<< HEAD
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
=======

public class LojaBiz {

    public Mensagem msg;

    public LojaBiz(){
        msg = new Mensagem();
    }

    public boolean Validade(Loja loja){
        boolean result = true;

        if(loja.getCredito() < 10000){
            msg.mensagens.add("O credito não pode ser inferior a R$10.000");
            result = false;
        }

        return result;
    }

>>>>>>> 702c833622e9c865f0d94c39ea66c69b69935db6
}
