package com.industria.roupa.controller;

import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.FuncaoBiz;
import com.industria.roupa.biz.RoupaBiz;
import com.industria.roupa.entities.Funcao;
import com.industria.roupa.entities.Roupa;
import com.industria.roupa.repositories.RoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("roupa")
@CrossOrigin
public class RoupaController {

    @Autowired
    private RoupaRepository roupaRepository;

    @GetMapping("listar")
    public List<Roupa> listar() {
        List<Roupa> lista = roupaRepository.findAll();
        return lista;
    }

    @PostMapping
    @RequestMapping("incluir")
    public Mensagem incluir(@RequestBody Roupa roupa) {
        roupa.setIdroupa(0);
        return add(roupa);
    }

    @PostMapping
    @RequestMapping("alterar")
    public Mensagem alterar(@RequestBody Roupa roupa) {
        return add(roupa);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Roupa Consultar(@PathVariable int id){
        return roupaRepository.findById(id).get();
    }


    public Mensagem add(Roupa roupa) {
        RoupaBiz roupaBiz = new RoupaBiz();
        try
        {
            if (roupaBiz.Validade(roupa)) {
                this.roupaRepository.save(roupa);
                this.roupaRepository.flush();
            } else {
                return roupaBiz.msg;
            }
        }
        catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> roupaBiz.msg.mensagens.add(v.getMessage()));
            return roupaBiz.msg;
        }

        roupaBiz.msg.mensagens.add("OK");

        return roupaBiz.msg;

    }
}

