package com.tuini.babies.app.controller;

import com.tuini.babies.app.service.FormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("forma-pago")
public class FormaPagoController {

    @Autowired
    private FormaPagoService formaPagoService;

    @GetMapping("/list")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(formaPagoService.getAll());
    }
}
