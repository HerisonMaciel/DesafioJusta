package com.justa.desafio.repository;

import com.justa.desafio.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    public Avatar findByImagem(String imagem);
    public void delete(Avatar avatar);
}
