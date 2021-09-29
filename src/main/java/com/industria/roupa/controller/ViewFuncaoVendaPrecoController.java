package com.industria.roupa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.industria.roupa.repositories.ViewFuncaoVendaPrecoRepository;
import com.industria.roupa.views.ViewFuncaoVendaPreco;

@RestController
@RequestMapping("viewfuncaovendapreco")
@CrossOrigin
public class ViewFuncaoVendaPrecoController {
	
	@Autowired
	private ViewFuncaoVendaPrecoRepository viewFuncaoVendaPrecoRepository;
	
	@GetMapping
	public List<ViewFuncaoVendaPreco> listar(){
		return viewFuncaoVendaPrecoRepository.findAll();
	}
	
}
