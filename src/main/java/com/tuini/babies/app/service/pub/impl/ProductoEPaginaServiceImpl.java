package com.tuini.babies.app.service.pub.impl;

import com.tuini.babies.app.model.*;
import com.tuini.babies.app.repository.CaracteristicaDetRepository;
import com.tuini.babies.app.repository.ProductoEcommerceRepository;
import com.tuini.babies.app.repository.ProductoPaginaRepository;
import com.tuini.babies.app.repository.pub.ProductoEPaginaRepository;
import com.tuini.babies.app.service.ProductoEcommerceService;
import com.tuini.babies.app.service.pub.ProductoEPaginaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoEPaginaServiceImpl implements ProductoEPaginaService {

    @Autowired
    private ProductoEPaginaRepository productoEPaginaRepository;

    @Autowired
    private ProductoPaginaRepository productoPaginaRepository;

    @Autowired
    private CaracteristicaDetRepository caracteristicaDetRepository;


    @Override
    public List<ProductosPagina> getAllEcommerce() {
        return productoPaginaRepository.getAllProductosPagina();
    }

    @Override
    public List<VwProductosPagina> getAllEcommerce2() {
        return this.productoEPaginaRepository.getAllEcommerce();
    }

    @Override
    public ProductosPagina getProductoPorId(String codigo) {
        return this.productoPaginaRepository.getProductoPorCodigo(codigo);
    }

    @Override
    public VwProductosPagina getProductoPorId2(String codigo) {
        return this.productoEPaginaRepository.getProductoPorId(codigo);
    }

    @Override
    public List<ProductosPagina> getProductosRelacionados(Long categoria_id) {
        return this.productoPaginaRepository.getProductosRelacionados(categoria_id);
    }

    @Override
    public List<ProductosPagina> getProductosRandom() {
        return this.productoPaginaRepository.getProductosRandom();
    }

    @Override
    public List<CaracteristicaDet> getCaracteristicas() {
        return caracteristicaDetRepository.getAll();
    }

    @Override
    public List<VwProductosPagina> getProductosRelacionados2(Long categoria_id) {
        return this.productoEPaginaRepository.getProductosRelacionados(categoria_id);
    }

    @Override
    public List<VwProductosPagina> getProductosRandom2() {
        return this.productoEPaginaRepository.getProductosRandom();
    }
}
