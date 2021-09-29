package com.industria.roupa.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ViewRoupaTecido {
	
	@Id
	@Column(name="idtecido")
	private Integer id;
	@Column(name="nome")
	private String nome;
	@Column(name="valorvenda")
	private Float valorvenda;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getValorvenda() {
		return valorvenda;
	}
	public void setValorvenda(Float valorvenda) {
		this.valorvenda = valorvenda;
	}
	


}
	


