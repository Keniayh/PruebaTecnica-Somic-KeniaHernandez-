package com.prueba.demo.infrastructure.repositories.factura;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.demo.application.services.IFacturaService;
import com.prueba.demo.domain.entities.Factura;

@Service
public class FacturaImpl implements IFacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }

    @Transactional
    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Factura> findById(int facCod) {
        return facturaRepository.findById(facCod);
    }

    @Transactional
    @Override
    public Optional<Factura> update(int facCod, Factura factura) {
        Optional<Factura> facOld = facturaRepository.findById(facCod);
        if (facOld.isPresent()) {
            Factura facDb = facOld.orElseThrow();
            facDb.setFacFecha(factura.getFacFecha());
            facDb.setFacVenc(factura.getFacVenc());
            facDb.setFacNatu(factura.getFacNatu());
            facDb.setFacTtalCost(factura.getFacTtalCost());
            facDb.setFacTtalVt(factura.getFacTtalVt());
            facDb.setKardex(factura.getKardex());
            facDb.setNit(factura.getNit());

            return Optional.of(facturaRepository.save(facDb));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Factura> delete(int facCod) {
        Optional<Factura> facOptional = facturaRepository.findById(facCod);
        facOptional.ifPresent(facDb -> {
            facturaRepository.delete(facDb);
        });
        return facOptional;
    }
}
