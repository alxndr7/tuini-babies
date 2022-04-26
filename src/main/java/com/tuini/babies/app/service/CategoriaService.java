package com.tuini.babies.app.service;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Linea;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getAll();
    Categoria create(Categoria linea);
    Categoria update(Categoria linea);
}
