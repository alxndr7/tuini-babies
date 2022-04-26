package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.OrdenCompraCab;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdenCompraRepository extends CrudRepository<OrdenCompraCab, Long> {

    @Query("select a from orden_compra_cab a")
    List<OrdenCompraCab> getAll();
}
