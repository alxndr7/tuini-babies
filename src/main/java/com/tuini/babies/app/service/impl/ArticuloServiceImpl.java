package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Articulo;
import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.repository.ArticuloRepository;
import com.tuini.babies.app.repository.LineaRepository;
import com.tuini.babies.app.service.ArticuloService;
import com.tuini.babies.app.service.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> getAll() {
        return articuloRepository.getAll();
    }

    @Override
    public Articulo create(Articulo linea) {
        return articuloRepository.save(linea);
    }

    @Override
    public Long count() {
        return articuloRepository.count();
    }

}
