package com.industria.roupa.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="tecido")
public class Tecido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTecido")
    private int idtecido;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "Preco")
    private double preco;

    @Column(name = "Medida")
    private double medida;

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }
}
