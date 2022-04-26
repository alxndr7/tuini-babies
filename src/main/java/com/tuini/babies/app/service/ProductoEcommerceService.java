package com.tuini.babies.app.service;

import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.model.ProductoEcommerce;

import java.util.List;

public interface ProductoEcommerceService {
    List<ProductoEcommerce> getAll();
    ProductoEcommerce create(ProductoEcommerce linea);
    ProductoEcommerce update(ProductoEcommerce linea);
}
