package com.industria.roupa.controller;

import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Mensagem add(@RequestBody Setor setor) {
        SetorBiz setorBiz = new SetorBiz(setorRepository);
        setor.setIdSetor(0);

        try {

            if (setorBiz.Validade(setor)) {
                this.setorRepository.save(setor);
                this.setorRepository.flush();
            } else {
                return setorBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> setorBiz.msg.mensagens.add(v.getMessage()));
            return setorBiz.msg;
        }

        setorBiz.msg.mensagens.add("OK");

        return setorBiz.msg;
    }
	

}
