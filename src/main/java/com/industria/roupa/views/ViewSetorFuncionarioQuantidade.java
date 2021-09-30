package com.industria.roupa.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="view_setor_funcionario_quantidade")
public class ViewSetorFuncionarioQuantidade {
	
	@Id
	@Column(name="idfuncionario")
	private Integer idFuncionario;
	@Column(name="nome")
	private String nome;
	@Column(name="quantidade")
	private Integer quantidade;
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer id) {
		this.idFuncionario = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
