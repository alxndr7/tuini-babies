package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.LogHistoProduct;
import com.tuini.babies.app.model.VwProductosRS;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface LogHistoProductRepository extends CrudRepository<LogHistoProduct, Long> {

    @Query(
            value = "select  distinct(u.id_carters, u.nombre_producto, u.imagen) FROM log_histo_product u",
            nativeQuery = true)
    List<LogHistoProduct> finAllDistinct();

    @Query(
            value = "select * FROM log_histo_product u where id_carters = :id",
            nativeQuery = true)
    List<LogHistoProduct> findLast30ById(String id);

    @Query(nativeQuery = true, value = "SELECT * FROM vw_all_rebajados")
    List<VwProductosRS> getProductosRebajados();

    @Query(nativeQuery = true, value = "SELECT * FROM vw_all_subidos")
    List<VwProductosRS> getProductosSubidos();

    @Query(nativeQuery = true, value = "SELECT * FROM vw_all_productos")
    List<VwProductosRS> getAllProductos();

    @Query(nativeQuery = true, value = "SELECT * FROM vw_all_productos where clearance = true order by diferencia asc")
    List<VwProductosRS> getAllProductosOfertados();

    @Query(nativeQuery = true, value = "SELECT * FROM log_histo_product where created_date > :dateIni" +
            " and created_date <  :dateFin")
    List<LogHistoProduct> getLogHoy(@Param("dateIni") Date dateIni, @Param("dateFin") Date dateFin);
}
