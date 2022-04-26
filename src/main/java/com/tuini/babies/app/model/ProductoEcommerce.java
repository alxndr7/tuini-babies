package com.tuini.babies.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity(name = "producto_ecommerce")
@Table(name = "producto_ecommerce")
public class ProductoEcommerce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;// public int id 0

    @Column(name = "activo")
    public Boolean activo;// false

    @Column(name = "codigo")
    public String codigo;

    @Column(name = "codigo_origen")
    public String codigoOrigen;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "descripcion")
    public String descripcion;

    @Column(name = "marca_id")
    public Integer marca;

    @Column(name = "linea_id")
    public Integer linea;

    @Column(name = "categoria_id")
    public Long categoria;

    @Column(name = "modelo")
    public String modelo;

    @Column(name = "producto_origen_id")
    public Integer productoOrigen;

    @Column(name = "ecommerce")
    public Boolean ecommerce;

    @Column(name = "ecom_img1_nombre")
    public String ecom_img1_nombre;

    @Column(name = "ecom_img2_nombre")
    public String ecom_img2_nombre;

    @Column(name = "ecom_img3_nombre")
    public String ecom_img3_nombre;

    @Column(name = "ecom_precio")
    public BigDecimal ecom_precio;

    @Column(name = "ecom_precio_dcto")
    public BigDecimal ecom_precio_dcto;

    @Column(name = "ecom_limite")
    public Integer ecom_limite;

    @Column(name = "stock_ecom")
    public Integer stock_ecom;

    @Column(name = "promocion")
    public Boolean promocion;

    @Column(name = "nuevo")
    public Boolean nuevo;

    @Column(name="utilidad", columnDefinition="Decimal(6,2) default '0.20'")
    public BigDecimal utilidad;

    @Column(name="descuento", columnDefinition="Decimal(6,2) default '0.0'")
    public BigDecimal descuento;

    @Column(name = "tipo_dcto")
    public String tipo_dcto;

    public Date creacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public String getCodigoOrigen() {
        return codigoOrigen;
    }

    public void setCodigoOrigen(String codigoOrigen) {
        this.codigoOrigen = codigoOrigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getProductoOrigen() {
        return productoOrigen;
    }

    public void setProductoOrigen(Integer productoOrigen) {
        this.productoOrigen = productoOrigen;
    }

    public Boolean getEcommerce() {
        return ecommerce;
    }

    public void setEcommerce(Boolean ecommerce) {
        this.ecommerce = ecommerce;
    }

    public String getEcom_img1_nombre() {
        return ecom_img1_nombre;
    }

    public void setEcom_img1_nombre(String ecom_img1_nombre) {
        this.ecom_img1_nombre = ecom_img1_nombre;
    }

    public String getEcom_img2_nombre() {
        return ecom_img2_nombre;
    }

    public void setEcom_img2_nombre(String ecom_img2_nombre) {
        this.ecom_img2_nombre = ecom_img2_nombre;
    }

    public String getEcom_img3_nombre() {
        return ecom_img3_nombre;
    }

    public void setEcom_img3_nombre(String ecom_img3_nombre) {
        this.ecom_img3_nombre = ecom_img3_nombre;
    }

    public BigDecimal getEcom_precio() {
        return ecom_precio;
    }

    public void setEcom_precio(BigDecimal ecom_precio) {
        this.ecom_precio = ecom_precio;
    }

    public Integer getEcom_limite() {
        return ecom_limite;
    }

    public void setEcom_limite(Integer ecom_limite) {
        this.ecom_limite = ecom_limite;
    }

    public Integer getStock_ecom() {
        return stock_ecom;
    }

    public void setStock_ecom(Integer stock_ecom) {
        this.stock_ecom = stock_ecom;
    }

    public Boolean getPromocion() {
        return promocion;
    }

    public void setPromocion(Boolean promocion) {
        this.promocion = promocion;
    }

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public BigDecimal getEcom_precio_dcto() {
        return ecom_precio_dcto;
    }

    public void setEcom_precio_dcto(BigDecimal ecom_precio_dcto) {
        this.ecom_precio_dcto = ecom_precio_dcto;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getTipo_dcto() {
        return tipo_dcto;
    }

    public void setTipo_dcto(String tipo_dcto) {
        this.tipo_dcto = tipo_dcto;
    }

    public Boolean hasPromo() {
        if (this.ecom_precio != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductoEcommerce{" +
                "id=" + id +
                ", categoria=" + categoria +
                '}';
    }
}
