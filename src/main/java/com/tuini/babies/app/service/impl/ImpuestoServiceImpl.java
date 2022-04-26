package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Impuesto;
import com.tuini.babies.app.repository.ImpuestoRepository;
import com.tuini.babies.app.service.ImpuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpuestoServiceImpl implements ImpuestoService {

    @Autowired
    private ImpuestoRepository impuestoRepository;

    @Override
    public List<Impuesto> getAll() {
        return impuestoRepository.getAll();
    }

}
