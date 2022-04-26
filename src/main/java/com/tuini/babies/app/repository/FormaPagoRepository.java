package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.FormaPago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormaPagoRepository extends CrudRepository<FormaPago, Long> {

    @Query("select a from formas_pago a where a.activo is true")
    List<FormaPago> getAll();
}
