package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Marca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarcaRepository extends CrudRepository<Marca, Long> {

    @Query("select a from marca a")
    List<Marca> getAll();
}
