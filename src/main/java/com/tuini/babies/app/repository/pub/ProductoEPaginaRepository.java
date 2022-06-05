package com.tuini.babies.app.repository.pub;

import com.tuini.babies.app.model.ProductoEcommerce;
import com.tuini.babies.app.model.VwProductosPagina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoEPaginaRepository extends CrudRepository<ProductoEcommerce, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM vw_productos_pagina")
    List<VwProductosPagina> getAllEcommerce();

    @Query(nativeQuery = true, value = "SELECT * FROM vw_productos_pagina where codigo = :codigo")
    VwProductosPagina getProductoPorId(String codigo);

    @Query(nativeQuery = true, value = "SELECT * FROM vw_productos_pagina where categoria_id = :id order by categoria_id, linea_id, marca_id limit 4")
    List<VwProductosPagina> getProductosRelacionados(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM vw_productos_pagina ORDER BY RAND() LIMIT 4")
    List<VwProductosPagina> getProductosRandom();


}
