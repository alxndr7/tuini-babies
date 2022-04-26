package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.FormaPago;
import com.tuini.babies.app.repository.FormaPagoRepository;
import com.tuini.babies.app.service.FormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagoServiceImpl implements FormaPagoService {

    @Autowired
    private FormaPagoRepository formaPagoRepository;

    @Override
    public List<FormaPago> getAll() {
        return formaPagoRepository.getAll();
    }

}
