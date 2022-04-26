package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.service.CategoriaService;
import com.tuini.babies.app.service.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody Categoria categoria) {
        categoria.setCreacion(new Date());
        categoria.setActivo(Boolean.TRUE);
        return ResponseEntity.ok(categoriaService.create(categoria));
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.update(categoria));
    }
}
