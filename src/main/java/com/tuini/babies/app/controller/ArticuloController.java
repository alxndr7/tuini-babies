package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.Articulo;
import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.service.ArticuloService;
import com.tuini.babies.app.service.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(articuloService.getAll());
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody Articulo item) {
        return ResponseEntity.ok(articuloService.create(item));
    }

    @GetMapping("/count")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok(articuloService.count());
    }

}
