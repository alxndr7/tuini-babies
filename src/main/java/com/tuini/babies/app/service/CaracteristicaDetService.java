package com.tuini.babies.app.service;

import com.tuini.babies.app.model.CaracteristicaDet;

import java.util.List;

public interface CaracteristicaDetService {
    List<CaracteristicaDet> getAll(Long id);
    CaracteristicaDet create(CaracteristicaDet item);
    CaracteristicaDet update(CaracteristicaDet item);
}
