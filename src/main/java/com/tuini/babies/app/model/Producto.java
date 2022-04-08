package com.tuini.babies.app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String id_carters;

    private String nombre_producto;

    private String imagen;

    private String url_producto;

    @Column(name="precio_descuento", columnDefinition="Decimal(6,2) default '0.00'")
    private Float precio_descuento;

    @Column(name="precio_original", columnDefinition="Decimal(6,2) default '0.00'")
    private Float precio_original;

    private Date createdDate;

    @Column(name="ultimo_precio_dscto", columnDefinition="Decimal(6,2) default '0.00'")
    private Float ultimo_precio_dscto;

    private Date fecha_ultimo_precio_dscto;

    @Column(name="penultimo_precio_dscto", columnDefinition="Decimal(6,2) default '0.00'")
    private Float penultimo_precio_dscto;

    private Date fecha_penultimo_precio_dscto;

    @Column(name="precio_max", columnDefinition="Decimal(6,2) default '0.00'")
    private Float precio_max;

    @Column(name="precio_min", columnDefinition="Decimal(6,2) default '0.00'")
    private Float precio_min;

    private Boolean clearance;

    private String oferta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_carters() {
        return id_carters;
    }

    public void setId_carters(String id_carters) {
        this.id_carters = id_carters;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl_producto() {
        return url_producto;
    }

    public void setUrl_producto(String url_producto) {
        this.url_producto = url_producto;
    }

    public Float getPrecio_descuento() {
        return precio_descuento;
    }

    public void setPrecio_descuento(Float precio_descuento) {
        this.precio_descuento = precio_descuento;
    }

    public Float getPrecio_original() {
        return precio_original;
    }

    public void setPrecio_original(Float precio_original) {
        this.precio_original = precio_original;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Float getUltimo_precio_dscto() {
        return ultimo_precio_dscto;
    }

    public void setUltimo_precio_dscto(Float ultimo_precio_dscto) {
        this.ultimo_precio_dscto = ultimo_precio_dscto;
    }

    public Date getFecha_ultimo_precio_dscto() {
        return fecha_ultimo_precio_dscto;
    }

    public void setFecha_ultimo_precio_dscto(Date fecha_ultimo_precio_dscto) {
        this.fecha_ultimo_precio_dscto = fecha_ultimo_precio_dscto;
    }

    public Float getPenultimo_precio_dscto() {
        return penultimo_precio_dscto;
    }

    public void setPenultimo_precio_dscto(Float penultimo_precio_dscto) {
        this.penultimo_precio_dscto = penultimo_precio_dscto;
    }

    public Date getFecha_penultimo_precio_dscto() {
        return fecha_penultimo_precio_dscto;
    }

    public void setFecha_penultimo_precio_dscto(Date fecha_penultimo_precio_dscto) {
        this.fecha_penultimo_precio_dscto = fecha_penultimo_precio_dscto;
    }

    public Float getPrecio_max() {
        return precio_max;
    }

    public void setPrecio_max(Float precio_max) {
        this.precio_max = precio_max;
    }

    public Float getPrecio_min() {
        return precio_min;
    }

    public void setPrecio_min(Float precio_min) {
        this.precio_min = precio_min;
    }

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id_carters='" + id_carters + '\'' +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", url_producto='" + url_producto + '\'' +
                ", clearance=" + clearance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id_carters, producto.id_carters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_carters, nombre_producto, imagen, url_producto, precio_descuento, precio_original, createdDate, ultimo_precio_dscto, fecha_ultimo_precio_dscto, penultimo_precio_dscto, fecha_penultimo_precio_dscto, precio_max, precio_min, clearance);
    }
}
