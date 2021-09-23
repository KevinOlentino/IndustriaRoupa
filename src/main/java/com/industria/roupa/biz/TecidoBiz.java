package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Tecido;

import javax.validation.Valid;

public class TecidoBiz {
    public Mensagem msg;

    public TecidoBiz() {msg = new Mensagem();}

    public boolean Validade(@Valid Tecido tecido){

        boolean result = true;
        msg = new Mensagem();

        if(tecido.getNome().isEmpty()) {
            msg.mensagens.add("o nome não pode ser vazio");
            result = false;
        }
        if(tecido.getNome().length() < 5 && tecido.getNome().length() > 50){
            msg.mensagens.add("O nome não pode ter menos que 5 letras e mais que 50 letras");
            result = false;
        }

        return result;
    }
}
