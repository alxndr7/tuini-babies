package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Caracteristica;
import com.tuini.babies.app.model.CaracteristicaDet;
import com.tuini.babies.app.repository.CaracteristicaDetRepository;
import com.tuini.babies.app.repository.CaracteristicaRepository;
import com.tuini.babies.app.service.CaracteristicaDetService;
import com.tuini.babies.app.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    @Override
    public List<Caracteristica> getAll() {
        return caracteristicaRepository.getAll();
    }

    @Override
    public Caracteristica create(Caracteristica categoria) {
        return caracteristicaRepository.save(categoria);
    }

    @Override
    public Caracteristica update(Caracteristica categoria) {
        Optional<Caracteristica> o = this.caracteristicaRepository.findById(categoria.getId());
        if(o.orElse(null) == null)
            return  categoria;
        Caracteristica upd = o.get();
        upd.setTipo(categoria.getTipo());
        upd.setDescripcion(categoria.getDescripcion());
        return this.caracteristicaRepository.save(upd);
    }
}
