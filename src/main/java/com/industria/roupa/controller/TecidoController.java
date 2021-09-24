package com.industria.roupa.controller;

import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.TecidoBiz;
import com.industria.roupa.entities.Tecido;
import com.industria.roupa.repositories.TecidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("tecido")
@CrossOrigin("http://localhost:4200/")
public class TecidoController {

    @Autowired
    private TecidoRepository tecidoRepository;

    @GetMapping("listar")
    public List<Tecido> listar() {
        List<Tecido> lista = tecidoRepository.findAll();
        return lista;
    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody Tecido tecido){
        tecido.setIdtecido(0);

        TecidoBiz tecidoBiz = new TecidoBiz();

        try {
            if (tecidoBiz.Validade(tecido)) {
                this.tecidoRepository.save(tecido);
                this.tecidoRepository.flush();
            } else {
                return tecidoBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> tecidoBiz.msg.mensagens.add(v.getMessage()));
            return tecidoBiz.msg;
        }
        tecidoBiz.msg.mensagens.add("OK");
        return tecidoBiz.msg;
    }
}
