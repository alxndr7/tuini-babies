package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Moneda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonedaRepository extends CrudRepository<Moneda, Long> {

    @Query("select a from moneda a where a.activo is true")
    List<Moneda> getAll();
}
