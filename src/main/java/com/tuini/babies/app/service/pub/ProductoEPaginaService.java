package com.tuini.babies.app.service.pub;

import com.tuini.babies.app.model.CaracteristicaDet;
import com.tuini.babies.app.model.ProductoEcommerce;
import com.tuini.babies.app.model.ProductosPagina;
import com.tuini.babies.app.model.VwProductosPagina;

import java.util.List;

public interface ProductoEPaginaService {

    List<VwProductosPagina> getAllEcommerce2();
    VwProductosPagina getProductoPorId2(String codigo);
    List<VwProductosPagina> getProductosRelacionados2(Long categoria_id);
    List<VwProductosPagina> getProductosRandom2();

    List<ProductosPagina> getAllEcommerce();
    List<ProductosPagina> getProductosOferta();
    ProductosPagina getProductoPorId(String codigo);
    List<ProductosPagina> getProductosRelacionados(Long categoria_id);
    List<ProductosPagina> getProductosRandom();
    List<CaracteristicaDet> getCaracteristicas();
}
