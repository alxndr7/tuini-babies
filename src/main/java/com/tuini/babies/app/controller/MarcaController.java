package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Marca;
import com.tuini.babies.app.service.CategoriaService;
import com.tuini.babies.app.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;


    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(marcaService.getAll());
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody Marca marca) {
        marca.setCreacion(new Date());
        marca.setActivo(Boolean.TRUE);
        return ResponseEntity.ok(marcaService.create(marca));
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.update(marca));
    }
}
