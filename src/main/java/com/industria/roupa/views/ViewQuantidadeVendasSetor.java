package com.industria.roupa.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="view_quantidade_vendas_setor")
public class ViewQuantidadeVendasSetor {

    @Id
    @Column(name = "idsetor")
    private Integer idSetor;

    @Column(name="setor")
    private String setor;

    @Column(name="Quantidade")
    private Integer quantidade;

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
