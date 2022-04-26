package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    @Query("select a from categoria a")
    List<Categoria> getAll();
}
