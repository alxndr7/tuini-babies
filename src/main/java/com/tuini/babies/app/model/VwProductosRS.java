package com.tuini.babies.app.model;

import java.util.Date;

public interface VwProductosRS {
        String getESTADO();

        String getIMAGEN();

        String getURL_PRODUCTO();

        String getID_CARTERS();

        Float getDIFERENCIA();

        String getULTIMO_PRECIO_DSCTO();

        Date getFECHA_ULTIMO_PRECIO_DSCTO();

        String getPENULTIMO_PRECIO_DSCTO();

        Date getFECHA_PENULTIMO_PRECIO_DSCTO();

        String getNOMBRE_PRODUCTO();

        Float getPRECIO_MIN();

        Float getPRECIO_MAX();

        Boolean getCLEARANCE();
}
