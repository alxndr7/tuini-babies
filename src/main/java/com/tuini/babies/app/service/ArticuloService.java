package com.tuini.babies.app.service;

import com.tuini.babies.app.model.Articulo;
import com.tuini.babies.app.model.Linea;

import java.util.List;

public interface ArticuloService {
    List<Articulo> getAll();
    Articulo create(Articulo item);
    Long count();
}
