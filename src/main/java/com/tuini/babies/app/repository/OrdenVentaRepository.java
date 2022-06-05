package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.OrdenVentaCab;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrdenVentaRepository extends CrudRepository<OrdenVentaCab, Long> {
    @Query("SELECT COUNT(u) FROM orden_venta_cab u")
    Long countOrdenes();
}
