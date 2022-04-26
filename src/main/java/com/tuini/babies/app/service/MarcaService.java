package com.tuini.babies.app.service;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Marca;

import java.util.List;

public interface MarcaService {
    List<Marca> getAll();
    Marca create(Marca linea);
    Marca update(Marca linea);
}
