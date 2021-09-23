package com.industria.roupa.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

public class Loja {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idloja")
    private int idloja;
	
	@Column(name = "nome")
    @Max(50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String Nome;
    
    @Column(name = "credito")
    @Max(50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String Credito;

    public int getIdloja() {
		return idloja;
	}

	public void setIdloja(int idloja) {
		this.idloja = idloja;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCredito() {
		return Credito;
	}

	public void setCredito(String credito) {
		Credito = credito;
	}

	
	
	

}
