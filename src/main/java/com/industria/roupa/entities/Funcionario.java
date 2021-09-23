package com.industria.roupa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome", nullable = false, length = 50)
	@Pattern(regexp="[A-z]{10,50}", message="O nome é inválido!")
	private String nome;
	
	@Column(name="cpf", nullable= false, length = 14)
	@Pattern(regexp="^\\d{3}.?\\d{3}.?\\d{3}-?\\d{2}$", message="CPF inválido")
	private String cpf;
	
	@Column(name="idsetor", nullable = false, precision=11)
	private int idSetor;
	
	@Column(name="email", nullable = false, length = 50)
	@Pattern(regexp="^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?/i", message="O Email é inválido!")
	private String email;
	
	@Min(value=1100, message="O valor não pode ser abaixo do salario minimo.")
	@Column(name="salario", nullable = false, precision=16, scale=2)
	private Double salario;
	
	@Column(name="idfuncao", nullable = false, precision=11)
	private int idFuncao;

	public int getId() {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(Integer idFuncao) {
		this.idFuncao = idFuncao;
	}
	
    
}
