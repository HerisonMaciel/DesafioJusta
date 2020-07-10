package com.justa.desafio.model.dto;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class AvatarDto {

    private URL url;
    private Image imagem;

    public AvatarDto(){}

    public AvatarDto(Image imagem, URL url) {
        this.imagem = imagem;
        this.url = url;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
