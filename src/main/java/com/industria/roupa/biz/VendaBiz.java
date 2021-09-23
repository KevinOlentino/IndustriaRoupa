package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Venda;
import com.industria.roupa.repositories.LojaRepository;
import com.industria.roupa.repositories.RoupaRepository;
import com.industria.roupa.repositories.FuncionarioRepository;

public class VendaBiz {
    public Mensagem msg;

    private LojaRepository lojaRepository;
    private RoupaRepository roupaRepository;
    private FuncionarioRepository funcionarioRepository;
    
    public VendaBiz(LojaRepository lojaRepository, RoupaRepository roupaRepository, FuncionarioRepository funcionarioRepository ) {
        msg = new Mensagem();
        this.lojaRepository = lojaRepository;
        this.roupaRepository = roupaRepository;
        this.funcionarioRepository= funcionarioRepository;
    }

    public Boolean Validade(Venda venda) {
       
        Boolean result = true;
      
        if (lojaRepository.findById(venda.getIdLoja()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }      
        if (roupaRepository.findById(venda.getIdRoupa()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        } 
        if (funcionarioRepository.findById(venda.getIdFuncionario()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }  
        if(result == true){
            msg.mensagens.add("OK");
        }
        return result;

    }

}