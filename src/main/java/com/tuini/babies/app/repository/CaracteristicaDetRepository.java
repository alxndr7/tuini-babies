package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.CaracteristicaDet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaracteristicaDetRepository extends CrudRepository<CaracteristicaDet, Long> {

    @Query("select a from caracteristica_det a where a.caracteristicaId = :id")
    List<CaracteristicaDet> getAllByCab(Long id);

    @Query("select a from caracteristica_det a")
    List<CaracteristicaDet> getAll();
}
