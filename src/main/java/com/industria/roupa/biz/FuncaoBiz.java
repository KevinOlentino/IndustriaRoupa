package com.industria.roupa.biz;

import javax.validation.Valid;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Funcao;

public class FuncaoBiz {
	
	public Mensagem msg;

    public FuncaoBiz(){
        msg = new Mensagem();
    }

    public Boolean Funcao(@Valid Funcao funcao) {

        Boolean result = true;
        msg = new Mensagem();

        if (funcao.getNome().isEmpty()) {
            msg.mensagens.add("O nome não pode ser vazio");
            result = false;

            if (funcao.getNome().length() < 5) {
                msg.mensagens.add("O nome não pode ter menos que 5 caracteres ");
                result = false;
            }

        }
        return result;
    }
    
}
	


