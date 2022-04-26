package com.tuini.babies.app.service.impl;

import com.tuini.babies.app.model.Categoria;
import com.tuini.babies.app.model.Linea;
import com.tuini.babies.app.repository.CategoriaRepository;
import com.tuini.babies.app.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAll() {
        return categoriaRepository.getAll();
    }

    @Override
    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        Optional<Categoria> o = this.categoriaRepository.findById(categoria.getId());
        if(o.orElse(null) == null)
            return  categoria;
        Categoria upd = o.get();
        upd.setNombre(categoria.getNombre());
        upd.setDescripcion(categoria.getDescripcion());
        return this.categoriaRepository.save(upd);
    }
}
