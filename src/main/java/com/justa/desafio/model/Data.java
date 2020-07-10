package com.justa.desafio.model;

import javax.persistence.*;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    private String textoHistorico;

    public Data(){}

    public Data(String textoHistorico) {
        this.textoHistorico = textoHistorico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoHistorico() {
        return textoHistorico;
    }

    public void setTextoHistorico(String textoHistorico) {
        this.textoHistorico = textoHistorico;
    }
}
