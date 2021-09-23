package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Setor;
import com.industria.roupa.repositories.SetorRepository;

public class SetorBiz {
    public Mensagem msg;

    public SetorRepository setorRepository;

    public SetorBiz(SetorRepository setorRepository){
        this.setorRepository = setorRepository;
        msg = new Mensagem();
    }

    public boolean Validade(Setor setor) {

        boolean result = true;

        if (!setorRepository.findByName(setor.getNome()).isEmpty()){
            msg.mensagens.add("Esse setor já foi adicionado.");
            result = false;
        }

        return result;
    }
}
