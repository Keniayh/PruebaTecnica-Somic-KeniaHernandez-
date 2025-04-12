package com.prueba.demo.infrastructure.repositories.facturaKardex;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.demo.domain.entities.FacturaKardex;

@Repository
public interface FacturaKardexRepository extends CrudRepository<FacturaKardex, Integer>{

}
