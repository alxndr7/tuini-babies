package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.ProductoEcommerce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoEcommerceRepository extends CrudRepository<ProductoEcommerce, Long> {
    @Query("select a from producto_ecommerce a")
    List<ProductoEcommerce> getAll();

    @Query(nativeQuery = true, value = "SELECT * FROM producto_ecommerce LIMIT 18")
    List<ProductoEcommerce> getAllEcommerce();

    @Query("select a from producto_ecommerce a where a.codigo = :codigo")
    ProductoEcommerce getProductoPorId(String codigo);
}
