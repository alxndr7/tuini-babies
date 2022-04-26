package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Moneda;
import com.tuini.babies.app.repository.MonedaRepository;
import com.tuini.babies.app.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public List<Moneda> getAll() {
        return monedaRepository.getAll();
    }

}
