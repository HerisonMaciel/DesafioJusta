package com.justa.desafio.repository;

import com.justa.desafio.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {

    public Data findByTextoHistorico(String data);
    public void delete(Data data);

}
