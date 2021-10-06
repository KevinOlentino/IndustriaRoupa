package com.industria.roupa.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.industria.roupa.Mensagem;
import com.industria.roupa.biz.LojaBiz;
import com.industria.roupa.entities.Loja;
import com.industria.roupa.repositories.LojaRepository;

@RestController
@RequestMapping("loja")
@CrossOrigin
public class LojaController {

	@Autowired
	private LojaRepository lojaRepository;

	@GetMapping
	@RequestMapping("listar")
	public List<Loja> Get() {
		return lojaRepository.findAll();
	}

	@PostMapping
	@RequestMapping("incluir")
	public Mensagem incluir(@RequestBody Loja loja) {
		loja.setIdloja(0);
		return salvar(loja);
	}

	@PostMapping
	@RequestMapping("alterar")
	public Mensagem alterar(@RequestBody Loja loja) {
		return salvar(loja);
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Loja consultar(@PathVariable Integer id) {
		return lojaRepository.findById(id).get();
		
	}

	public Mensagem salvar(Loja loja) {
		LojaBiz lojaBiz = new LojaBiz(lojaRepository);

		try {

			if (lojaBiz.Validade(loja)) {
				this.lojaRepository.save(loja);
				this.lojaRepository.flush();
			} else {
				return lojaBiz.msg;
			}
		} catch (ConstraintViolationException e) {
			e.getConstraintViolations().forEach(v -> lojaBiz.msg.mensagens.add(v.getMessage()));
			return lojaBiz.msg;
		}

		lojaBiz.msg.mensagens.add("OK");

		return lojaBiz.msg;

	}
}
