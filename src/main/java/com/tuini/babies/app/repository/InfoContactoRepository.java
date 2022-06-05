package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.Articulo;
import com.tuini.babies.app.model.InfoContacto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InfoContactoRepository extends CrudRepository<InfoContacto, Long> {

}
