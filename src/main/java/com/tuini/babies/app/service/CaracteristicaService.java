package com.tuini.babies.app.service;

import com.tuini.babies.app.model.Caracteristica;

import java.util.List;

public interface CaracteristicaService {
    List<Caracteristica> getAll();
    Caracteristica create(Caracteristica linea);
    Caracteristica update(Caracteristica linea);
}
