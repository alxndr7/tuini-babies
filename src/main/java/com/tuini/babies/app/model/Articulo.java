package com.tuini.babies.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity(name = "articulo")
@Table(name = "articulo")
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "producto_id")
    public Long productoId;

    @Column(name = "orden_compra_id")
    private Long ordenCompraId;

    @Column(name = "orden_compra_det_id")
    private Long ordenCompraDetId;

    @Column(name = "caracteristica_det_id")
    public Long caracteristicaDetId;

    public Boolean activo;

    public String serie;

    public String serieCompra;

    public Boolean vendido;

    public String observaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaracteristicaDetId() {
        return caracteristicaDetId;
    }

    public void setCaracteristicaDetId(Long caracteristicaDetId) {
        this.caracteristicaDetId = caracteristicaDetId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getOrdenCompraDetId() {
        return ordenCompraDetId;
    }

    public void setOrdenCompraDetId(Long ordenCompraDetId) {
        this.ordenCompraDetId = ordenCompraDetId;
    }

    public Long getOrdenCompraId() {
        return ordenCompraId;
    }

    public void setOrdenCompraId(Long ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSerieCompra() {
        return serieCompra;
    }

    public void setSerieCompra(String serieCompra) {
        this.serieCompra = serieCompra;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
