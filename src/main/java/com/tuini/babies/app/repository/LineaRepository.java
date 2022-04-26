package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Linea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LineaRepository extends CrudRepository<Linea, Long> {

    @Query("select a from linea a")
    List<Linea> getAll();
}
