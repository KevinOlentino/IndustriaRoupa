package com.industria.roupa.controller;

import com.industria.roupa.repositories.ViewQuantidadeVendasSetorRepository;
import com.industria.roupa.views.ViewQuantidadeVendasSetor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("viewquantidadevendassetor")
public class ViewQuantidadeVendasSetorController {
    @Autowired
    private ViewQuantidadeVendasSetorRepository viewQuantidadeVendasSetorRepository;

    @GetMapping
    public List<ViewQuantidadeVendasSetor> listar(){return viewQuantidadeVendasSetorRepository.findAll(); }

}
