package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Loja;

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

}
