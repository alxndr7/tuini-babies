package com.tuini.babies.app.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "orden_compra_det")
@Table(name = "orden_compra_det")
public class OrdenCompraDet implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "orden_compra_id")
    public Long ordenCompra;
    
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

    public Long getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Long ordenCompra) {
        this.ordenCompra = ordenCompra;
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
        final OrdenCompraDet other = (OrdenCompraDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenCompraDet{" +
                "id=" + id +
                ", ordenCompra=" + ordenCompra +
                ", productoId=" + productoId +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
