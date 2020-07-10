package com.justa.desafio.controller;

import com.justa.desafio.model.Avatar;
import com.justa.desafio.model.dto.AvatarDto;
import com.justa.desafio.service.AvatarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AvatarController {


    private AvatarService avatarService;
    public AvatarController(AvatarService avatarService){ this.avatarService = avatarService; }

    @GetMapping("/avatar/{texto}")
    public ResponseEntity<AvatarDto> criarAvatar(@PathVariable String texto) throws IOException {
        AvatarDto avatarDto = this.avatarService.criarAvatar(texto);
        return ResponseEntity.ok(avatarDto);
    }

}
