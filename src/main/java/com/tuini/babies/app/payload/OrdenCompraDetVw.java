package com.tuini.babies.app.payload;

import java.math.BigDecimal;

public class OrdenCompraDetVw {
    private Long ID;
    private Long ID_ITEMS_TABLE;
    private Long ORDEN_COMPRA_ID;
    private Long PRODUCTO_ID;
    private String NOMBRE;
    private String CODIGO;
    private Long CARACTERISTICA_DET_ID;
    private String DESCRIPCION;
    private BigDecimal PRECIO_UNITARIO;
    private BigDecimal CANTIDAD;
    private Long CARACTERISTICA_ID;
    private BigDecimal IMPORTE;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID_ITEMS_TABLE() {
        return ID_ITEMS_TABLE;
    }

    public void setID_ITEMS_TABLE(Long ID_ITEMS_TABLE) {
        this.ID_ITEMS_TABLE = ID_ITEMS_TABLE;
    }

    public Long getORDEN_COMPRA_ID() {
        return ORDEN_COMPRA_ID;
    }

    public void setORDEN_COMPRA_ID(Long ORDEN_COMPRA_ID) {
        this.ORDEN_COMPRA_ID = ORDEN_COMPRA_ID;
    }

    public Long getPRODUCTO_ID() {
        return PRODUCTO_ID;
    }

    public void setPRODUCTO_ID(Long PRODUCTO_ID) {
        this.PRODUCTO_ID = PRODUCTO_ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCARACTERISTICA_DET_ID() {
        return CARACTERISTICA_DET_ID;
    }

    public void setCARACTERISTICA_DET_ID(Long CARACTERISTICA_DET_ID) {
        this.CARACTERISTICA_DET_ID = CARACTERISTICA_DET_ID;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public BigDecimal getPRECIO_UNITARIO() {
        return PRECIO_UNITARIO;
    }

    public void setPRECIO_UNITARIO(BigDecimal PRECIO_UNITARIO) {
        this.PRECIO_UNITARIO = PRECIO_UNITARIO;
    }

    public BigDecimal getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(BigDecimal CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public Long getCARACTERISTICA_ID() {
        return CARACTERISTICA_ID;
    }

    public void setCARACTERISTICA_ID(Long CARACTERISTICA_ID) {
        this.CARACTERISTICA_ID = CARACTERISTICA_ID;
    }

    public BigDecimal getIMPORTE() {
        return IMPORTE;
    }

    public void setIMPORTE(BigDecimal IMPORTE) {
        this.IMPORTE = IMPORTE;
    }

    @Override
    public String toString() {
        return "OrdenCompraDetVw{" +
                "ID=" + ID +
                ", ORDEN_COMPRA_ID=" + ORDEN_COMPRA_ID +
                ", PRODUCTO_ID=" + PRODUCTO_ID +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", CODIGO='" + CODIGO + '\'' +
                ", CARACTERISTICA_DET_ID=" + CARACTERISTICA_DET_ID +
                ", DESCRIPCION='" + DESCRIPCION + '\'' +
                ", PRECIO_UNITARIO=" + PRECIO_UNITARIO +
                ", CANTIDAD=" + CANTIDAD +
                ", CARACTERISTICA_ID=" + CARACTERISTICA_ID +
                ", IMPORTE=" + IMPORTE +
                '}';
    }
}
