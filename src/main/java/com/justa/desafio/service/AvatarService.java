package com.justa.desafio.service;

import com.justa.desafio.model.Avatar;
import com.justa.desafio.model.dto.AvatarDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.net.URL;

@Service
public class AvatarService {


    public AvatarDto criarAvatar(String texto) throws IOException {

        URL url = new URL(String.format("https://api.adorable.io/avatars/%s.png",texto));
        Image imagem = ImageIO.read(url);

        AvatarDto avatarDto = new AvatarDto();
        avatarDto.setImagem(imagem);
        avatarDto.setUrl(url);

        return avatarDto;
    }

}
