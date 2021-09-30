package com.industria.roupa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.industria.roupa.repositories.ViewVendaLojaRepository;
import com.industria.roupa.views.ViewVendaLoja;

@RestController
@RequestMapping("viewvendaloja")
@CrossOrigin
public class ViewVendaLojaController {
	
	@Autowired
	private ViewVendaLojaRepository viewVendaLojaRepository;
	
	@GetMapping
	public List<ViewVendaLoja> listar(){
		return viewVendaLojaRepository.findAll();
	}

}
