package com.tuini.babies.app.controller;

import com.tuini.babies.app.model.Caracteristica;
import com.tuini.babies.app.model.CaracteristicaDet;
import com.tuini.babies.app.service.CaracteristicaDetService;
import com.tuini.babies.app.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("caracteristica-det")
public class CaracteristicaDetController {

    @Autowired
    private CaracteristicaDetService caracteristicaDetService;


    @GetMapping("/list/{id}")
    public ResponseEntity<?> listar(@PathVariable(value="id") Long id) {
        return ResponseEntity.ok(caracteristicaDetService.getAll(id));
    }

    @PostMapping("/create")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> create(@RequestBody CaracteristicaDet item) {
        return ResponseEntity.ok(caracteristicaDetService.create(item));
    }

    @PostMapping("/update")
    // @PreAuthorize("hasAuthority('ADMIN_MTTO') or hasAuthority('ADMIN_MTTO')")
    public ResponseEntity<?> update(@RequestBody CaracteristicaDet item) {
        return ResponseEntity.ok(caracteristicaDetService.update(item));
    }
}
