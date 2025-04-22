package com.prueba.demo.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.prueba.demo.domain.entities.Factura;

@Service
public interface IFacturaService {
    List<Factura> findAll();

    Factura save(Factura factura);

    Optional<Factura> findById(int facCod);

    Optional<Factura> update(int facCod, Factura factura);

    Optional<Factura> delete(int facCod);
}
