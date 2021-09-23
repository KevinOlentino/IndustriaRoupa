package com.industria.roupa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idvenda")
	private int idVenda;
	
	@Column(name="idfuncionario", nullable = false)	
	private int idFuncionario;
		
	@Column(name="idloja", nullable = false)
	private int idLoja;	

	@Column(name="idroupa", nullable = false)
	private int idRoupa;

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}

	public int getIdRoupa() {
		return idRoupa;
	}

	public void setIdRoupa(int idRoupa) {
		this.idRoupa = idRoupa;
	}

	
}

