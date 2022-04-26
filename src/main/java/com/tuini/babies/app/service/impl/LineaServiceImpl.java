package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.repository.LineaRepository;
import com.tuini.babies.app.service.CategoriaService;
import com.tuini.babies.app.service.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineaServiceImpl implements LineaService {

    @Autowired
    private LineaRepository lineaRepository;

    @Override
    public List<Linea> getAll() {
        return lineaRepository.getAll();
    }

    @Override
    public Linea create(Linea linea) {
        return lineaRepository.save(linea);
    }

    @Override
    public Linea update(Linea linea) {
        Optional<Linea> o = this.lineaRepository.findById(linea.getId());
        if(o.orElse(null) == null)
            return  linea;
        Linea upd = o.get();
        upd.setNombre(linea.getNombre());
        upd.setDescripcion(linea.getDescripcion());
        return this.lineaRepository.save(upd);
    }
}
