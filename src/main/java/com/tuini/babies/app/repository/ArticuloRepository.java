package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Articulo;
import com.tuini.babies.app.model.Linea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticuloRepository extends CrudRepository<Articulo, Long> {

    @Query("select a from articulo a")
    List<Articulo> getAll();

    @Query("SELECT COUNT(u) FROM articulo u")
    Long countArticulos(String name);

    @Query("SELECT COUNT(u) FROM articulo u where u.productoId = :productoId and u.caracteristicaDetId = :caracteristicaDetId and u.vendido = false")
    Long countArticuloByProductoAndCaract(Long productoId, Long caracteristicaDetId);

    @Transactional
    Long deleteByOrdenCompraId(Long ocId);
}
