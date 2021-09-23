package com.industria.roupa.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

public class Funcao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfuncao")
    private int idFuncao;

    @Column(name = "nome")
    @Max(50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String nome;

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

}
