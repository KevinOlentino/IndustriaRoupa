package com.industria.roupa.biz;


import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Roupa;

import javax.validation.Valid;

public class RoupaBiz {

    public Mensagem msg;

    public RoupaBiz() {msg = new Mensagem();}

    public boolean Roupeiro(@Valid Roupa roupa){

        boolean result = true;
        msg = new Mensagem();

        if(roupa.getNome().isEmpty()) {
            msg.mensagens.add("o nome não pode ser vazio");
            result = false;
        }
            if(roupa.getNome().length() < 5 && roupa.getNome().length() > 50){
                msg.mensagens.add("O nome não pode ser menor que 5 letras e maior que 50 letras");
                result = false;
            }
            if(roupa.getPreco() < 30 && roupa.getPreco()> 90) {
                msg.mensagens.add("O preço deve ser entre 30 á 90");
                result = false;
            }
        return result;
        }

    }

