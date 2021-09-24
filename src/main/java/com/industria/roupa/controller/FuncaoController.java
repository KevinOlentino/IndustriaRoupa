package com.industria.roupa.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.FuncaoBiz;
import com.industria.roupa.entities.Funcao;
import com.industria.roupa.repositories.FuncaoRepository;

@RestController
@RequestMapping("funcao")
public class FuncaoController {

	@Autowired
	private FuncaoRepository funcaoRepository;

	@GetMapping
	@RequestMapping("listar")
	public List<Funcao> Get() {
		return funcaoRepository.findAll();
	}
	
	 @PostMapping
	    @RequestMapping("incluir")
	    public Mensagem add(@RequestBody Funcao funcao) {
	        FuncaoBiz funcaoBiz = new FuncaoBiz();
	        funcao.setIdFuncao(0);

	        try {

	            if (funcaoBiz.Validade(funcao)) {
	                this.funcaoRepository.save(funcao);
	                this.funcaoRepository.flush();
	            } else {
	                return funcaoBiz.msg;
	            }
	        }catch (ConstraintViolationException e) {
	            e.getConstraintViolations().forEach(v -> funcaoBiz.msg.mensagens.add(v.getMessage()));
	            return funcaoBiz.msg;
	        }

			funcaoBiz.msg.mensagens.add("OK");

	        return funcaoBiz.msg;


	    }
}
