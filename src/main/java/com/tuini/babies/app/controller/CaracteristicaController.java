package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.Caracteristica;
import com.tuini.babies.app.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("caracteristica")
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService caracteristicaService;


    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(caracteristicaService.getAll());
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody Caracteristica item) {
        item.setCreacion(new Date());
        item.setActivo(Boolean.TRUE);
        return ResponseEntity.ok(caracteristicaService.create(item));
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody Caracteristica item) {
        return ResponseEntity.ok(caracteristicaService.update(item));
    }
}
