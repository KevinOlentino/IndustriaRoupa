package com.industria.roupa.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_venda_loja")
public class ViewVendaLoja {

	@Id
	@Column(name = "idvenda")
	private Integer idVenda;
	@Column(name = "loja")
	private String Loja;
	@Column(name = "somapreco")
	private Double somaPreco;

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public String getLoja() {
		return Loja;
	}

	public void setLoja(String loja) {
		Loja = loja;
	}

	public Double getSomaPreco() {
		return somaPreco;
	}

	public void setSomaPreco(Double somaPreco) {
		this.somaPreco = somaPreco;
	}

}
