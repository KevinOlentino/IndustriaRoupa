package com.industria.roupa.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="view_quantidade_tecido")
public class ViewQuantidadeTecido {

    @Id
    @Column(name="idroupa")
    private Integer id;
    @Column(name="roupa")
    private String roupa;
    @Column(name="quantidade")
    private int quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoupa() {
        return roupa;
    }

    public void setRoupa(String roupa) {
        this.roupa = roupa;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
