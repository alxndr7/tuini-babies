package com.tuini.babies.app.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "producto_pagina")
@Table(name = "producto_pagina")
public class ProductosPagina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;// public int id 0

    @Column(name = "producto_id")
    public Long productoId;

    @Column(name = "activo")
    public Boolean activo;// false

    @Column(name = "codigo")
    public String codigo;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "descripcion")
    public String descripcion;

    @Column(name = "ecommerce")
    public Boolean ecommerce;

    @Column(name = "promocion")
    public Boolean promocion;

    @Column(name = "nuevo")
    public Boolean nuevo;

    @Column(name = "ecom_precio")
    public BigDecimal ecom_precio;

    @Column(name = "ecom_precio_ant")
    public BigDecimal ecom_precio_ant;

    @Column(name = "stock_ecom")
    public Integer stock_ecom;

    @Column(columnDefinition = "integer default 0")
    public Integer stock;

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

    @Column(name = "marca_id")
    public Integer marcaId;

    @Column(name = "marca")
    public String marca;

    @Column(name = "linea_id")
    public Integer lineaId;

    @Column(name = "linea")
    public String linea;

    @Column(name = "categoria_id")
    public Long categoriaId;

    @Column(name = "categoria")
    public String categoria;

    @Column(name = "id_talla_compra")
    public Long id_talla_compra;

    @Column(name = "talla_compra")
    public String talla_compra;

    @Column(name = "cant_compra")
    public Integer cant_compra;

    @Column(name = "tallas")
    public String tallas;

    @Column(name = "max_por_talla")
    public Long max_por_talla;

    @Column(name = "qty")
    public String qty;

    @Column(name = "sum")
    public String sum;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public Long getId_talla_compra() {
        return id_talla_compra;
    }

    public void setId_talla_compra(Long id_talla_compra) {
        this.id_talla_compra = id_talla_compra;
    }

    public String getTalla_compra() {
        return talla_compra;
    }

    public void setTalla_compra(String talla_compra) {
        this.talla_compra = talla_compra;
    }

    public Integer getCant_compra() {
        return cant_compra;
    }

    public void setCant_compra(Integer cant_compra) {
        this.cant_compra = cant_compra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEcommerce() {
        return ecommerce;
    }

    public void setEcommerce(Boolean ecommerce) {
        this.ecommerce = ecommerce;
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

    public Integer getStock_ecom() {
        return stock_ecom;
    }

    public void setStock_ecom(Integer stock_ecom) {
        this.stock_ecom = stock_ecom;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getLineaId() {
        return lineaId;
    }

    public void setLineaId(Integer lineaId) {
        this.lineaId = lineaId;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTallas() {
        return tallas;
    }

    public void setTallas(String tallas) {
        this.tallas = tallas;
    }

    public Long getMax_por_talla() {
        return max_por_talla;
    }

    public void setMax_por_talla(Long max_por_talla) {
        this.max_por_talla = max_por_talla;
    }
}
