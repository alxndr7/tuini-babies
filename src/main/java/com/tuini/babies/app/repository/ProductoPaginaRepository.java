package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.ProductosPagina;
import com.tuini.babies.app.model.VwProductosPagina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductoPaginaRepository extends CrudRepository<ProductosPagina, Long> {

    ProductosPagina findByProductoId(Long productoId);

    @Query("select a from producto_pagina a")
    List<ProductosPagina> getAllProductosPagina();

    @Query("select a from producto_pagina a where a.codigo = :codigo")
    ProductosPagina getProductoPorCodigo(String codigo);

    @Query(nativeQuery = true, value = "SELECT * FROM producto_pagina where categoria_id = :id order by categoria_id, linea_id, marca_id limit 4")
    List<ProductosPagina> getProductosRelacionados(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM producto_pagina ORDER BY RAND() LIMIT 4")
    List<ProductosPagina> getProductosRandom();

/*    @Query("select a from producto a")
    List<Producto> getAllProductos();

    @Transactional
    @Modifying
    @Query(value = "UPDATE producto u set clearance = false where u.id > 0",
            nativeQuery = true)
    void updateClearance();

    @Query(value = "select u.* from producto u where u.categoria is null ", nativeQuery = true)
    List<Producto> getAllSinCategoria();*/
}
