package com.justa.desafio.repository;

import com.justa.desafio.model.Usuario;
import com.justa.desafio.model.dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
    public Usuario findByKey(String key);
    public void delete(Usuario usuario);

}
