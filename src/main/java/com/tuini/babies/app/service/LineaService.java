package com.tuini.babies.app.service;

import com.tuini.babies.app.model.Linea;

import java.util.List;

public interface LineaService {
    List<Linea> getAll();
    Linea create(Linea linea);
    Linea update(Linea linea);
}
