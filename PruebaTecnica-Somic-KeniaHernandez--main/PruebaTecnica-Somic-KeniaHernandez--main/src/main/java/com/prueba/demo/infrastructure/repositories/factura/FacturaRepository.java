package com.prueba.demo.infrastructure.repositories.factura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.demo.domain.entities.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Integer>{

}
