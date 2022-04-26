package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.OrdenCompraCab;
import com.tuini.babies.app.repository.OrdenCompraRepository;
import com.tuini.babies.app.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Override
    public List<OrdenCompraCab> getAll() {
        return ordenCompraRepository.getAll();
    }

}
