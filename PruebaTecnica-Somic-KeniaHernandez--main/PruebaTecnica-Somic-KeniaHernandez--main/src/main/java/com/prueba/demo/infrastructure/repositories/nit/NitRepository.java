package com.prueba.demo.infrastructure.repositories.nit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.demo.domain.entities.Nit;

@Repository
public interface NitRepository extends CrudRepository<Nit, Integer> {

}
