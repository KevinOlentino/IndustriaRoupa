package com.industria.roupa.controller;

import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.RoupaTecidoBiz;
import com.industria.roupa.entities.RoupaTecido;
import com.industria.roupa.repositories.RoupaRepository;
import com.industria.roupa.repositories.RoupaTecidoRepository;
import com.industria.roupa.repositories.TecidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("roupatecido")
public class RoupaTecidoController {

    @Autowired
    private RoupaTecidoRepository roupaTecidoRepository;

    @Autowired
    private RoupaRepository roupaRepository;

    @Autowired
    private TecidoRepository tecidoRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<RoupaTecido> Get() {
        return roupaTecidoRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem add(@RequestBody RoupaTecido roupaTecido) {
        RoupaTecidoBiz roupaTecidoBiz = new RoupaTecidoBiz(roupaRepository, tecidoRepository);
        roupaTecido.setIdRoupaTecido(0);

        try {

            if (roupaTecidoBiz.Validade(roupaTecido)) {
                this.roupaTecidoRepository.save(roupaTecido);
                this.roupaTecidoRepository.flush();
            } else {
                return roupaTecidoBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> roupaTecidoBiz.msg.mensagens.add(v.getMessage()));
            return roupaTecidoBiz.msg;
        }

        roupaTecidoBiz.msg.mensagens.add("OK");

        return roupaTecidoBiz.msg;


    }
}
