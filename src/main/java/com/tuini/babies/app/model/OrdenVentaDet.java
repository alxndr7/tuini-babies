package com.tuini.babies.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "orden_venta_det")
@Table(name = "orden_venta_det")
public class OrdenVentaDet implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "orden_venta_id")
    public Long ordenVentaId;
    
    @Column(name = "producto_id")
    public Long productoId;
    
    @Column(name = "cantidad")
    public BigDecimal cantidad;
    
    @Column(name = "precio_unitario")
    public BigDecimal precioUnitario;

    @Column(name = "caracteristicaDet_id")
    public Long caracteristicaDetId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdenVentaId() {
        return ordenVentaId;
    }

    public void setOrdenVentaId(Long ordenVentaId) {
        this.ordenVentaId = ordenVentaId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getCaracteristicaDetId() {
        return caracteristicaDetId;
    }

    public void setCaracteristicaDetId(Long caracteristicaDetId) {
        this.caracteristicaDetId = caracteristicaDetId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdenVentaDet other = (OrdenVentaDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
