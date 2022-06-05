package com.tuini.babies.app.service;

import com.tuini.babies.app.model.OrdenCompraDet;
import com.tuini.babies.app.model.OrdeCompraDetVw;

import java.util.List;

public interface OrdenCompraDetService {
    List<OrdenCompraDet> getAll();
    List<OrdenCompraDet> getAllByOc(Long id);
    List<OrdeCompraDetVw> getAllVwByOc(Long id);
    OrdenCompraDet create(OrdenCompraDet item);
    List<OrdenCompraDet> createAll(List<OrdenCompraDet> items);
    List<OrdenCompraDet> updateAll(List<OrdenCompraDet> items);
    void deleteDetalle(Long id);
}
