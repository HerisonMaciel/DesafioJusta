package com.justa.desafio.repository;

import com.justa.desafio.model.Feriado;
import com.justa.desafio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Long> {

    public Feriado findByDate(String date);
    public Feriado findByName(String name);
    public void delete(Feriado feriado);

}
