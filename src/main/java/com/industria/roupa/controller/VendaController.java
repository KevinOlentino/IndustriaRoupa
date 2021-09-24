package com.industria.roupa.controller;

import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.VendaBiz;
import com.industria.roupa.entities.Venda;
import com.industria.roupa.repositories.VendaRepository;
import com.industria.roupa.repositories.LojaRepository;
import com.industria.roupa.repositories.RoupaRepository;
import com.industria.roupa.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("venda")
@CrossOrigin("http://localhost:4200/")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private RoupaRepository roupaRepository;
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<Venda> Get() {
        return vendaRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem add(@RequestBody Venda venda) {
        VendaBiz vendaBiz = new VendaBiz(lojaRepository, roupaRepository, funcionarioRepository);
        venda.setIdVenda(0);

        try {

            if (vendaBiz.Validade(venda)) {
                this.vendaRepository.save(venda);
                this.vendaRepository.flush();
            } else {
                return vendaBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> vendaBiz.msg.mensagens.add(v.getMessage()));
            return vendaBiz.msg;
        }

        vendaBiz.msg.mensagens.add("OK");

        return vendaBiz.msg;


    }
}
