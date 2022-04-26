package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.service.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("linea")
public class LineaController {

    @Autowired
    private LineaService lineaService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(lineaService.getAll());
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody Linea linea) {
        linea.setCreacion(new Date());
        linea.setActivo(Boolean.TRUE);
        return ResponseEntity.ok(lineaService.create(linea));
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody Linea linea) {
        return ResponseEntity.ok(lineaService.update(linea));
    }

}
