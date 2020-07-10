package com.justa.desafio.model;

import javax.persistence.*;
import java.util.UUID;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private long id;
    private String email;
    private String key;

    public Usuario() {
        this.key = gerarKey();
    }

    public Usuario(String email){
        this.email = email;
        this.key = gerarKey();
    }

    public Usuario(String email, String key) {
        this.email = email;
        this.key = key;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public static String gerarKey(){
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return myRandom.substring(0,20);
    }
}
