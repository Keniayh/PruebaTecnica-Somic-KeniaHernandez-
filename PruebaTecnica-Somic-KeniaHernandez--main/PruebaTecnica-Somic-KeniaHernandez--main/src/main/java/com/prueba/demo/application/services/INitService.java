package com.prueba.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.prueba.demo.domain.entities.Nit;

@Service
public interface INitService {
    List<Nit> findAll();

    Nit save(Nit nit);

    Optional<Nit> findById(int nitCod);

    Optional<Nit> update(int nitCod, Nit nit);

    Optional<Nit> delete(int nitCod);
}
