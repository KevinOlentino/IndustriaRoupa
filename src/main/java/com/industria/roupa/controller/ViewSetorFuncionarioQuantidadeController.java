package com.industria.roupa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.industria.roupa.repositories.ViewSetorFuncionarioQuantidadeRepository;
import com.industria.roupa.views.ViewSetorFuncionarioQuantidade;

@RestController
@RequestMapping("viewsetorfuncionarioquantidade")
@CrossOrigin("http://localhost:4200/")
public class ViewSetorFuncionarioQuantidadeController {

	@Autowired
	ViewSetorFuncionarioQuantidadeRepository viewSetorFuncionarioQuantidadeRepository;

	@GetMapping
	public List<ViewSetorFuncionarioQuantidade> listar() {
		return viewSetorFuncionarioQuantidadeRepository.findAll();
	}
}
