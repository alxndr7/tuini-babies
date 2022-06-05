package com.tuini.babies.app.model;

import java.math.BigDecimal;

public interface OrdeCompraDetVw {

        Long getID_ITEMS_TABLE();

        Long getID();

        Long getORDEN_COMPRA_ID();

        Long getPRODUCTO_ID();

        String getNOMBRE();

        String getCODIGO();

        Long getCARACTERISTICA_DET_ID();

        String getDESCRIPCION();

        BigDecimal getPRECIO_UNITARIO();

        BigDecimal getCANTIDAD();

        Long getCARACTERISTICA_ID();

        BigDecimal getIMPORTE();
}
