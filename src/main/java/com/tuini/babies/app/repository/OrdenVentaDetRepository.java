package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.OrdenVentaDet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrdenVentaDetRepository extends CrudRepository<OrdenVentaDet, Long> {
}
