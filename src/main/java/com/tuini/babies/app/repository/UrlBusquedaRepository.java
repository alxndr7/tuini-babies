package com.tuini.babies.app.repository;


import com.tuini.babies.app.model.UrlBusqueda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface UrlBusquedaRepository extends CrudRepository<UrlBusqueda, Long> {

    @Query("select a from UrlBusqueda a where a.activo = true")
    List<UrlBusqueda> getAllUrl();
}
