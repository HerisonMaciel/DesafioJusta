package com.justa.desafio.model;


import javax.persistence.*;
import java.awt.*;
import java.net.URL;

@Entity
public class Avatar {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    private String imagem;
    private String url;

    public Avatar() {
    }

    public Avatar(String imagem, String url) {
        this.imagem = imagem;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
