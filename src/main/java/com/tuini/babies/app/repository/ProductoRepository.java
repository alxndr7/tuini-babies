package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Producto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query("select a from producto a")
    List<Producto> getAllProductos();

    @Transactional
    @Modifying
    @Query(value = "UPDATE producto u set clearance = false where u.id > 0",
            nativeQuery = true)
    void updateClearance();

    @Query(value = "select u.* from producto u where u.categoria is null ", nativeQuery = true)
    List<Producto> getAllSinCategoria();
}
