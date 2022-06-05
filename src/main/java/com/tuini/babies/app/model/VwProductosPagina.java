package com.tuini.babies.app.model;

import java.math.BigDecimal;

public interface VwProductosPagina {
        Long getID();
        Boolean getACTIVO();
        String getCODIGO();
        String getNOMBRE();
        String getDESCRIPCION();
        BigDecimal getECOM_PRECIO();
        BigDecimal getECOM_PRECIO_ANT();
        Long getSTOCK_ECOM();
        Long getSTOCK();
        Boolean getPROMOCION();
        Boolean getNUEVO();
        Boolean getECOMMERCE();
        String getECOM_IMG1();
        String getECOM_IMG2();
        String getECOM_IMG3();
        Long getMARCA_ID();
        String getMARCA();
        Long getLINEA_ID();
        String getLINEA();
        Long getCATEGORIA_ID();
        String getCATEGORIA();
}
