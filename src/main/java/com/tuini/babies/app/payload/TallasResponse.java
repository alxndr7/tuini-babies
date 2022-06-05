package com.tuini.babies.app.payload;

public class TallasResponse {
    private Long caracteristicaDetId;
    private String descripcion;
    private Long cantidad;

    public TallasResponse(Long caracteristicaDetId, String descripcion, Long cantidad) {
        this.caracteristicaDetId = caracteristicaDetId;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Long getCaracteristicaDetId() {
        return caracteristicaDetId;
    }

    public void setCaracteristicaDetId(Long caracteristicaDetId) {
        this.caracteristicaDetId = caracteristicaDetId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "TallasResponse{" +
                "caracteristicaDetId=" + caracteristicaDetId +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
