/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuini.babies.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity(name = "orden_compra_cab")
@Table(name = "orden_compra_cab")
public class OrdenCompraCab implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "anulada")
    public Boolean anulada;
    
    @Column(name = "moneda_id")
    public Long monedaId;
    
    @Column(name = "direccion_proveedor_id")
    public Long direccionProveedorId;

    @Column(name = "fecha_compra")
    public Date fechaCompra;
    
    @Column(name = "fecha_llegada")
    public Date fechaLLegada;
    
    @Column(name = "forma_pago_id")
    public Long formaPagoId;
    
    @Column(name = "impuesto_incluido")
    public Boolean impuestoIncluido;
    
    @Column(name = "impuesto_id")
    public Long impuestoId;
    
    @Column(name = "total")
    public BigDecimal total;
    
    @Column(name = "impuesto")
    public BigDecimal impuesto;
    
    @Column(name = "subtotal")
    public BigDecimal subtotal;

    @Column(name = "tipo_cambio")
    public BigDecimal tipoCambio;
    
    @Column(name = "cerrada")
    public Boolean cerrada;
    
    @Column(name = "dias_credito")
    public Integer diasCredito;

    @Column(name = "numero")
    public String numero;
    
    @Column(name = "monto_pagado")
    public BigDecimal montoPagado;
    
    @Column(name = "total_pagar")
    public BigDecimal totalPagar;
    
    @Column(name = "descuento")
    public BigDecimal descuento;  

    @Column(name="numero_facturas")
    public String numeroFacturas;

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

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public Long getMonedaId() {
        return monedaId;

    }

    public void setMonedaId(Long monedaId) {
        this.monedaId = monedaId;
    }

    public Long getDireccionProveedorId() {
        return direccionProveedorId;
    }

    public void setDireccionProveedorId(Long direccionProveedorId) {
        this.direccionProveedorId = direccionProveedorId;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(Date fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

    public Long getFormaPagoId() {
        return formaPagoId;
    }

    public void setFormaPagoId(Long formaPagoId) {
        this.formaPagoId = formaPagoId;
    }

    public Boolean getImpuestoIncluido() {
        return impuestoIncluido;
    }

    public void setImpuestoIncluido(Boolean impuestoIncluido) {
        this.impuestoIncluido = impuestoIncluido;
    }

    public Long getImpuestoId() {
        return impuestoId;
    }

    public void setImpuestoId(Long impuestoId) {
        this.impuestoId = impuestoId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Boolean getCerrada() {
        return cerrada;
    }

    public void setCerrada(Boolean cerrada) {
        this.cerrada = cerrada;
    }

    public Integer getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(Integer diasCredito) {
        this.diasCredito = diasCredito;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
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

    public String getNumeroFacturas() {
        return numeroFacturas;
    }

    public void setNumeroFacturas(String numeroFacturas) {
        this.numeroFacturas = numeroFacturas;
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
        final OrdenCompraCab other = (OrdenCompraCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
