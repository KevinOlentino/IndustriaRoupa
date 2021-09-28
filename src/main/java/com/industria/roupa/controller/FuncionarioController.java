package com.industria.roupa.controller;

import java.text.ParseException;
import java.util.List;
import java.util.TimeZone;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.FuncionarioBiz;
import com.industria.roupa.entities.Funcionario;
import com.industria.roupa.repositories.FuncaoRepository;
import com.industria.roupa.repositories.FuncionarioRepository;
import com.industria.roupa.repositories.SetorRepository;

@RestController
@RequestMapping("Funcionario")
@CrossOrigin("http://localhost:4200/")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncaoRepository funcaoRepository;

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<Funcionario> Get() {
        return funcionarioRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem incluir(@RequestBody Funcionario funcionario) {
        System.out.println(funcionario.getDatadeContratacao());
        funcionario.setIdFuncionario(0);
        return add(funcionario);
    }

    @PostMapping
    @RequestMapping("alterar")
    public Mensagem alterar(@RequestBody Funcionario funcionario) {
       // funcionario.getDatadeContratacao().setHours(0);
        System.out.println(TimeZone.getDefault());
        System.out.println(funcionario.getDatadeContratacao());
        return add(funcionario);
    }

    @GetMapping
    @RequestMapping("/{idFuncionario}")
    public Funcionario Consultar(@PathVariable int idFuncionario){
        return funcionarioRepository.findById(idFuncionario).get();
    }


    public Mensagem add(Funcionario funcionario) {
        FuncionarioBiz funcionarioBiz = new FuncionarioBiz(setorRepository, funcaoRepository);
        System.out.println(funcionario.getDatadeContratacao());
        try
        {
            if (funcionarioBiz.Validade(funcionario)) {
                this.funcionarioRepository.save(funcionario);
                this.funcionarioRepository.flush();
            } else {
                return funcionarioBiz.msg;
            }
        }
        catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> funcionarioBiz.msg.mensagens.add(v.getMessage()));
            return funcionarioBiz.msg;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        funcionarioBiz.msg.mensagens.add("OK");

        return funcionarioBiz.msg;


    }
}



