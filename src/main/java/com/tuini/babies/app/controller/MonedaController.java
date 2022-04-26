package com.tuini.babies.app.controller;

import com.tuini.babies.app.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("moneda")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(monedaService.getAll());
    }
}
