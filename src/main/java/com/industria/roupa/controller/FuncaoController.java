package com.industria.roupa.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.industria.roupa.biz.FuncionarioBiz;
import com.industria.roupa.entities.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.FuncaoBiz;
import com.industria.roupa.entities.Funcao;
import com.industria.roupa.repositories.FuncaoRepository;

@RestController
@RequestMapping("funcao")
@CrossOrigin("http://localhost:4200/")
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
	public Mensagem incluir(@RequestBody Funcao funcao) {
		funcao.setIdFuncao(0);
		return add(funcao);
	}

	@PostMapping
	@RequestMapping("alterar")
	public Mensagem alterar(@RequestBody Funcao funcao) {
		return add(funcao);
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Funcao Consultar(@PathVariable int id){
		return funcaoRepository.findById(id).get();
	}


	public Mensagem add(Funcao funcao) {
		FuncaoBiz funcaoBiz = new FuncaoBiz();
		try
		{
			if (funcaoBiz.Validade(funcao)) {
				this.funcaoRepository.save(funcao);
				this.funcaoRepository.flush();
			} else {
				return funcaoBiz.msg;
			}
		}
		catch (ConstraintViolationException e) {
			e.getConstraintViolations().forEach(v -> funcaoBiz.msg.mensagens.add(v.getMessage()));
			return funcaoBiz.msg;
		}

		funcaoBiz.msg.mensagens.add("OK");

		return funcaoBiz.msg;

	}
}
