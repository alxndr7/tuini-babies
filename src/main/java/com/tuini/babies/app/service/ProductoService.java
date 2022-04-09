package com.tuini.babies.app.service;

import com.tuini.babies.app.model.LogHistoProduct;
import com.tuini.babies.app.model.Producto;
import com.tuini.babies.app.model.UrlBusqueda;
import com.tuini.babies.app.model.VwProductosRS;

import java.io.IOException;
import java.util.List;


public interface ProductoService {
    List<Producto> insertarNuevosProductos() throws IOException;
    List<LogHistoProduct> insertarLogProductos(List<Producto> list);
    String actualizarProductos();
    void saveupdateall();
    List<VwProductosRS> getAllProductos(String categoria);
    List<LogHistoProduct> findLast30ById(String idCarters);
    List<VwProductosRS> getProductosSubidos(String categoria);
    List<VwProductosRS> getProductosRebajados(String categoria);
    List<VwProductosRS>  getAllProductosOfertados(String categoria);
    String updateCategoria();
    List<UrlBusqueda> getCategorias();
}
