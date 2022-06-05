package com.tuini.babies.app.service;

import com.tuini.babies.app.model.OrdenCompraCab;
import com.tuini.babies.app.model.OrdenCompraDet;
import com.tuini.babies.app.payload.OrdeCompraRequest;

import java.math.BigDecimal;
import java.util.List;

public interface OrdenCompraService {
    List<OrdenCompraCab> getAll();
    List<OrdenCompraCab> listCerradas();
    OrdenCompraCab create(OrdenCompraCab item, List<OrdenCompraDet> list);
    List<OrdenCompraCab> createAll(List<OrdenCompraCab> items);
    OrdenCompraCab update(OrdeCompraRequest item);
    OrdenCompraCab cerrarOc(Long id);
    OrdenCompraCab validarProceso(Long id);
    OrdenCompraCab anularProceso(Long id);
    Long anularDescarga(Long id);
    Long count();
}
