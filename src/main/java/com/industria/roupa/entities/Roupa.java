package com.industria.roupa.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="roupa")
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idroupa")
    private int idroupa;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String nome;

    @Column(name = "preco",precision = 12,scale = 2)
    private double preco;

    @Column(name = "medida")
    private double medida;

    public int getIdroupa() {
        return idroupa;
    }

    public void setIdroupa(int idroupa) {
        this.idroupa = idroupa;
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
