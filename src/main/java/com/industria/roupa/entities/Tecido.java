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
    @Pattern(regexp = "[30-90]", message = "O preço deve ser entre 30 á 90")
    private double preco;

    @Column(name = "Medida")
    private double medida;

}
