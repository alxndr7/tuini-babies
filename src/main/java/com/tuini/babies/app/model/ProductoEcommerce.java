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

    @Column(name = "ecom_img1")
    public String ecom_img1;

    @Column(name = "ecom_img2")
    public String ecom_img2;

    @Column(name = "ecom_img3")
    public String ecom_img3;

    @Column(name = "ecom_img4")
    public String ecom_img4;

    @Column(name = "ecom_img5")
    public String ecom_img5;

    @Column(name = "ecom_precio")
    public BigDecimal ecom_precio;

    @Column(name = "ecom_precio_ant")
    public BigDecimal ecom_precio_ant;

    @Column(name = "ecom_limite")
    public Integer ecom_limite;

    @Column(name = "stock_ecom")
    public Integer stock_ecom;

    @Column(columnDefinition = "integer default 0")
    public Integer stock;

    @Column(name = "promocion")
    public Boolean promocion;

    @Column(name = "nuevo")
    public Boolean nuevo;

    @Column(name="utilidad", columnDefinition="Decimal(6,2) default '0.20'")
    public BigDecimal utilidad;

    public Date creacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public String getCodigoOrigen() {
        return codigoOrigen;
    }

    public void setCodigoOrigen(String codigoOrigen) {
        this.codigoOrigen = codigoOrigen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
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

    public String getEcom_img1() {
        return ecom_img1;
    }

    public void setEcom_img1(String ecom_img1) {
        this.ecom_img1 = ecom_img1;
    }

    public String getEcom_img2() {
        return ecom_img2;
    }

    public void setEcom_img2(String ecom_img2) {
        this.ecom_img2 = ecom_img2;
    }

    public String getEcom_img3() {
        return ecom_img3;
    }

    public void setEcom_img3(String ecom_img3) {
        this.ecom_img3 = ecom_img3;
    }

    public BigDecimal getEcom_precio() {
        return ecom_precio;
    }

    public void setEcom_precio(BigDecimal ecom_precio) {
        this.ecom_precio = ecom_precio;
    }

    public BigDecimal getEcom_precio_ant() {
        return ecom_precio_ant;
    }

    public void setEcom_precio_ant(BigDecimal ecom_precio_ant) {
        this.ecom_precio_ant = ecom_precio_ant;
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

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public String getEcom_img4() {
        return ecom_img4;
    }

    public void setEcom_img4(String ecom_img4) {
        this.ecom_img4 = ecom_img4;
    }

    public String getEcom_img5() {
        return ecom_img5;
    }

    public void setEcom_img5(String ecom_img5) {
        this.ecom_img5 = ecom_img5;
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
