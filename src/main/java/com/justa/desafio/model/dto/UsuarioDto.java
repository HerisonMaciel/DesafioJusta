package com.justa.desafio.model.dto;

import com.justa.desafio.model.Usuario;

import java.util.UUID;

public class UsuarioDto {

    private Long id;
    private String email;
    private String key;

    public UsuarioDto(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        this.key = myRandom.substring(0,20);
    }

    public UsuarioDto(String email) {
        this.email = email;
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        this.key = myRandom.substring(0,20);
    }

    public UsuarioDto(String email, String key){
        this.email = email;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
