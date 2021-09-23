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
	private Integer idVenda;
	
	@Column(name="idfuncionario", nullable = false)	
	private Integer idFuncionario;
		
	@Column(name="idloja", nullable = false)
	private Integer idLoja;	

	@Column(name="idroupa", nullable = false)
	private Integer idRoupa;

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Integer getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Integer idLoja) {
		this.idLoja = idLoja;
	}

	public Integer getIdRoupa() {
		return idRoupa;
	}

	public void setIdRoupa(Integer idRoupa) {
		this.idRoupa = idRoupa;
	}
		
}

