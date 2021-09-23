package com.industria.roupa.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Setor")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsetor")
    private int idSetor;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "[A-z ]{5,50}")
    private String nome;

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
