package com.tuini.babies.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity(name = "orden_venta_cab")
@Table(name = "orden_venta_cab")
public class OrdenVentaCab implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "anulada")
    public Boolean anulada;

    @Column(name = "pagada")
    public Boolean pagada;
    
    @Column(name = "comprador_id")
    public Long compradorId;

    @Column(name = "fecha_compra")
    public Date fechaCompra;

    @Column(name = "numero")
    public String numero;
    
    @Column(name = "total_pagar")
    public BigDecimal totalPagar;
    
    @Column(name = "descuento")
    public BigDecimal descuento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public Boolean getPagada() {
        return pagada;
    }

    public void setPagada(Boolean pagada) {
        this.pagada = pagada;
    }

    public Long getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Long compradorId) {
        this.compradorId = compradorId;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(BigDecimal totalPagar) {
        this.totalPagar = totalPagar;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "OrdenVentaCab{" +
                "id=" + id +
                ", anulada=" + anulada +
                ", pagada=" + pagada +
                ", compradorId=" + compradorId +
                ", fechaCompra=" + fechaCompra +
                ", numero='" + numero + '\'' +
                ", totalPagar=" + totalPagar +
                ", descuento=" + descuento +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final OrdenVentaCab other = (OrdenVentaCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
