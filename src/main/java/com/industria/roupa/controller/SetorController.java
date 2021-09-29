package com.industria.roupa.controller;

import java.util.List;
import javax.validation.ConstraintViolationException;

import com.industria.roupa.biz.RoupaTecidoBiz;
import com.industria.roupa.entities.Roupa;
import com.industria.roupa.entities.RoupaTecido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.SetorBiz;
import com.industria.roupa.entities.Setor;
import com.industria.roupa.repositories.SetorRepository;



@RestController
@RequestMapping("setor")
@CrossOrigin("http://localhost:4200/")
public class SetorController {
	
	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping
    @RequestMapping("listar")
    public List<Setor> Get() {
        return setorRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem incluir(@RequestBody Setor setor) {
        setor.setIdSetor(0);
        return add(setor);
    }

    @PostMapping
    @RequestMapping("alterar")
    public Mensagem alterar(@RequestBody Setor setor) {
        return add(setor);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Setor Consultar(@PathVariable int id){
        return setorRepository.findById(id).get();
    }


    public Mensagem add(Setor setor) {
        SetorBiz setorBiz = new SetorBiz(setorRepository);
        try
        {
            if (setorBiz.Validade(setor)) {
                this.setorRepository.save(setor);
                this.setorRepository.flush();
            } else {
                return setorBiz.msg;
            }
        }
        catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> setorBiz.msg.mensagens.add(v.getMessage()));
            return setorBiz.msg;
        }

        setorBiz.msg.mensagens.add("OK");

        return setorBiz.msg;

    }
	

}
