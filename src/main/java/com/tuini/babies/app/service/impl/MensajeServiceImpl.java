package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Articulo;
import com.tuini.babies.app.model.Mensaje;
import com.tuini.babies.app.repository.ArticuloRepository;
import com.tuini.babies.app.repository.MensajeRepository;
import com.tuini.babies.app.service.ArticuloService;
import com.tuini.babies.app.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServiceImpl implements MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Override
    public Mensaje create(Mensaje item) {
        return mensajeRepository.save(item);
    }

}
