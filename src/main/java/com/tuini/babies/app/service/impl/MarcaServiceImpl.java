package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Marca;
import com.tuini.babies.app.repository.CategoriaRepository;
import com.tuini.babies.app.repository.MarcaRepository;
import com.tuini.babies.app.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> getAll() {
        return marcaRepository.getAll();
    }

    @Override
    public Marca create(Marca categoria) {
        return marcaRepository.save(categoria);
    }

    @Override
    public Marca update(Marca categoria) {
        Optional<Marca> o = this.marcaRepository.findById(categoria.getId());
        if(o.orElse(null) == null)
            return  categoria;
        Marca upd = o.get();
        upd.setNombre(categoria.getNombre());
        upd.setDescripcion(categoria.getDescripcion());
        return this.marcaRepository.save(upd);
    }
}
