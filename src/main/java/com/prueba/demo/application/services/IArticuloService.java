package com.prueba.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.prueba.demo.domain.entities.Articulo;

@Service
public interface IArticuloService {
    List<Articulo> findAll();

    Articulo save(Articulo articulo);

    Optional<Articulo> findById(int artCod);

    Optional<Articulo> update(int artCod, Articulo articulo);

    Optional<Articulo> delete(int artCod);
}
