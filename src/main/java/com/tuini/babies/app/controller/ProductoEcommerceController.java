package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.model.ProductoEcommerce;
import com.tuini.babies.app.service.LineaService;
import com.tuini.babies.app.service.ProductoEcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("producto-ecommerce")
public class ProductoEcommerceController {

    @Autowired
    private ProductoEcommerceService productoEcommerceService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(productoEcommerceService.getAll());
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody ProductoEcommerce producto) {
        producto.setCreacion(new Date());
        producto.setActivo(Boolean.TRUE);
        return ResponseEntity.ok(productoEcommerceService.create(producto));
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody ProductoEcommerce producto) {
        return ResponseEntity.ok(productoEcommerceService.update(producto));
    }

}
