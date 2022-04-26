package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Caracteristica;
import com.tuini.babies.app.model.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaracteristicaRepository extends CrudRepository<Caracteristica, Long> {

    @Query("select a from caracteristica a")
    List<Caracteristica> getAll();
}
