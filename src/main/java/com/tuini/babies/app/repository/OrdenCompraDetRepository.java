package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.OrdenCompraDet;
import com.tuini.babies.app.model.OrdeCompraDetVw;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdenCompraDetRepository extends CrudRepository<OrdenCompraDet, Long> {

    @Query("select a from orden_compra_det a")
    List<OrdenCompraDet> getAll();

    @Query("select a from orden_compra_det a where a.ordenCompra = :id")
    List<OrdenCompraDet> getAllByOc(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM vw_orden_compra_det where orden_compra_id = :id")
    List<OrdeCompraDetVw> getDetalleOrdenCompra(@Param("id") Long id);
}
