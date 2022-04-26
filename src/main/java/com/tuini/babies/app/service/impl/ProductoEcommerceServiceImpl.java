package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.model.ProductoEcommerce;
import com.tuini.babies.app.repository.ProductoEcommerceRepository;
import com.tuini.babies.app.service.ProductoEcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoEcommerceServiceImpl implements ProductoEcommerceService {

    @Autowired
    private ProductoEcommerceRepository productoEcommerceRepository;

    @Override
    public List<ProductoEcommerce> getAll() {
        return this.productoEcommerceRepository.getAll();
    }

    @Override
    public ProductoEcommerce create(ProductoEcommerce producto) {
        return  this.productoEcommerceRepository.save(producto);
    }

    @Override
    public ProductoEcommerce update(ProductoEcommerce producto) {

        System.out.println(producto.toString());
        Optional<ProductoEcommerce> o = this.productoEcommerceRepository.findById(producto.getId());
        if(o.orElse(null) == null)
            return  producto;
        ProductoEcommerce upd = o.get();
        upd.setCodigo(producto.getCodigo());
        upd.setCodigoOrigen(producto.getCodigoOrigen());
        upd.setNombre(producto.getNombre());
        upd.setDescripcion(producto.getDescripcion());
        upd.setMarca(producto.getMarca());
        upd.setLinea(producto.getLinea());
        upd.setModelo(producto.getModelo());
        upd.setProductoOrigen(producto.getProductoOrigen());
        upd.setEcommerce(producto.getEcommerce());
        upd.setEcom_img1_nombre(producto.getEcom_img1_nombre());
        upd.setEcom_img2_nombre(producto.getEcom_img2_nombre());
        upd.setEcom_img3_nombre(producto.getEcom_img3_nombre());
        upd.setEcom_precio(producto.getEcom_precio());
        upd.setEcom_limite(producto.getEcom_limite());
        upd.setStock_ecom(producto.getStock_ecom());
        upd.setPromocion(producto.getPromocion());
        upd.setCategoria(producto.getCategoria());
        upd.setNuevo(producto.getNuevo());
        upd.setEcom_precio_dcto(producto.getEcom_precio_dcto());
        upd.setUtilidad(producto.getUtilidad());
        upd.setDescuento(producto.getDescuento());
        upd.setTipo_dcto(producto.getTipo_dcto());

        return this.productoEcommerceRepository.save(upd);
    }
}
