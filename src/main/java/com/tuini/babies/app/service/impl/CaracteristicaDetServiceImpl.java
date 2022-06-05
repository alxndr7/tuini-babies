package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.CaracteristicaDet;
import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.repository.CaracteristicaDetRepository;
import com.tuini.babies.app.repository.CategoriaRepository;
import com.tuini.babies.app.service.CaracteristicaDetService;
import com.tuini.babies.app.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaDetServiceImpl implements CaracteristicaDetService {

    @Autowired
    private CaracteristicaDetRepository caracteristicaDetRepository;

    @Override
    public List<CaracteristicaDet> getAll(Long id) {
        return caracteristicaDetRepository.getAllByCab(id);
    }

    @Override
    public CaracteristicaDet create(CaracteristicaDet categoria) {
        return caracteristicaDetRepository.save(categoria);
    }

    @Override
    public CaracteristicaDet update(CaracteristicaDet categoria) {
        Optional<CaracteristicaDet> o = this.caracteristicaDetRepository.findById(categoria.getId());
        if(o.orElse(null) == null)
            return  categoria;
        CaracteristicaDet upd = o.get();
        upd.setCaracteristicaId(categoria.getCaracteristicaId());
        upd.setDescripcion(categoria.getDescripcion());
        return this.caracteristicaDetRepository.save(upd);
    }
}
