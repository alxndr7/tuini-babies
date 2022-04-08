package com.tuini.babies.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class LogHistoProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String id_carters;

    private String nombre_producto;

    private String imagen;

    private Float precio_descuento;

    private Float precio_original;

    private Date createdDate;

    private Boolean clearance;

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

    public String getImagen() {
        return imagen;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }

    @Override
    public String toString() {
        return "LogHistoProduct{" +
                "id_carters='" + id_carters + '\'' +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", clearance=" + clearance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogHistoProduct that = (LogHistoProduct) o;
        return id_carters.equals(that.id_carters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_carters);
    }
}
