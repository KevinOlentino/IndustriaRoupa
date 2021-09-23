package com.industria.roupa.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="roupa")
public class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRoupa")
    private int idroupa;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "Preco")
    @Pattern(regexp = "[30-90 ]{5,50}", message = "O nome é invalido!")
    private double preco;

    @Column(name = "Medida")
    private double medida;
}
