package com.industria.roupa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.industria.roupa.repositories.ViewRoupaTecidoRepository;
import com.industria.roupa.views.ViewRoupaTecido;

@RestController
@RequestMapping("viewRoupaTecido")
@CrossOrigin
public class ViewRoupaTecidoController {
	
	@Autowired
	private ViewRoupaTecidoRepository viewRoupaTecidoRepository;
	
	@GetMapping
	public List<ViewRoupaTecido> listar(){
		return viewRoupaTecidoRepository.findAll();

	}
	
}

