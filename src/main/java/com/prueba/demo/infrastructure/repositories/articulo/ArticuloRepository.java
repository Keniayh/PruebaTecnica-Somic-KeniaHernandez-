package com.prueba.demo.infrastructure.repositories.articulo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.demo.domain.entities.Articulo;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Integer>{

}
