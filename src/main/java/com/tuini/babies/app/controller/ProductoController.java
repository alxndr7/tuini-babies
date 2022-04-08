package com.tuini.babies.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @GetMapping("hola-mundo")
    public String holaMundo(){
        return "HOLA MUNDO";
    }
}
