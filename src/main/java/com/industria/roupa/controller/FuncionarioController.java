package com.industria.roupa.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.FuncionarioBiz;
import com.industria.roupa.entities.Funcionario;
import com.industria.roupa.repositories.FuncaoRepository;
import com.industria.roupa.repositories.FuncionarioRepository;
import com.industria.roupa.repositories.SetorRepository;

@RestController
@RequestMapping("Funcionario")
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
	    public Mensagem add(@RequestBody Funcionario funcionario) throws ParseException {
	    	FuncionarioBiz funcionarioBiz = new FuncionarioBiz( setorRepository,  funcaoRepository);
	        funcionario.setIdFuncionario(0);

	        try {

	            if (funcionarioBiz.Validade(funcionario)) {
	                this.funcionarioRepository.save(funcionario);
	                this.funcionarioRepository.flush();
	            } else {
	                return funcionarioBiz.msg;
	            }
	        }catch (ConstraintViolationException e) {
	            e.getConstraintViolations().forEach(v -> funcionarioBiz.msg.mensagens.add(v.getMessage()));
	            return funcionarioBiz.msg;
	        }

	        return funcionarioBiz.msg;


	    }
	}



