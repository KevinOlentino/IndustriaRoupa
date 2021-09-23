package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Setor;
import com.industria.roupa.repositories.SetorRepository;

public class SetorBiz {
    public Mensagem msg;

    public SetorRepository setorRepository;

    public SetorBiz(SetorRepository setorRepository){
        msg = new Mensagem();
        this.setorRepository = setorRepository;
    }

    public boolean Validade(Setor setor) {

        boolean result = true;

        if (!setorRepository.findByNome(setor.getNome()).isEmpty()){
            msg.mensagens.add("Esse setor já foi adicionado.");
            result = false;
        }

        return result;
    }
}
