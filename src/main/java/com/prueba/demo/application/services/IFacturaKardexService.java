package com.prueba.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.prueba.demo.domain.entities.FacturaKardex;

@Service
public interface IFacturaKardexService {
    List<FacturaKardex> findAll();

    FacturaKardex save (FacturaKardex facturaKardex);

    Optional<FacturaKardex> findById(int facKCod);

    Optional<FacturaKardex> update(int facKCod, FacturaKardex facturaKardex);

    Optional<FacturaKardex> delete(int facKCod);
}

