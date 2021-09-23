package com.industria.roupa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roupatecido")
public class RoupaTecido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idroupatecido")
	private int idRoupaTecido;

	@Column(name = "idroupa", nullable = false, precision = 11, scale = 0)
	private int idRoupa;

	@Column(name = "idtecido", nullable = false, precision = 11, scale = 0)
	private int idTecido;

	public int getIdRoupaTecido() {
		return idRoupaTecido;
	}

	public void setIdRoupaTecido(int idRoupaTecido) {
		this.idRoupaTecido = idRoupaTecido;
	}

	public int getIdRoupa() {
		return idRoupa;
	}

	public void setIdRoupa(int idRoupa) {
		this.idRoupa = idRoupa;
	}

	public int getIdTecido() {
		return idTecido;
	}

	public void setIdTecido(int idTecido) {
		this.idTecido = idTecido;
	}

}
