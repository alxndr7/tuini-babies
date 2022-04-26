package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Impuesto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImpuestoRepository extends CrudRepository<Impuesto, Long> {

    @Query("select a from impuestos a where a.activo is true")
    List<Impuesto> getAll();
}
