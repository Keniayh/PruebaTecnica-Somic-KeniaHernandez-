package com.prueba.demo.infrastructure.repositories.facturaKardex;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.demo.application.services.IFacturaKardexService;
import com.prueba.demo.domain.entities.FacturaKardex;

@Service
public class FacturaKardexImpl implements IFacturaKardexService {
    @Autowired
    private FacturaKardexRepository facturaKRepository;

    @Transactional(readOnly = true)
    @Override
    public List<FacturaKardex> findAll() {
        return (List<FacturaKardex>) facturaKRepository.findAll();
    }

    @Transactional
    @Override
    public FacturaKardex save(FacturaKardex facturaKardex) {
        return facturaKRepository.save(facturaKardex);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<FacturaKardex> findById(int facKCod) {
        return facturaKRepository.findById(facKCod);
    }

    @Transactional
    @Override
    public Optional<FacturaKardex> update(int facKCod, FacturaKardex facturaK) {
        Optional<FacturaKardex> facKOld = facturaKRepository.findById(facKCod);
        if (facKOld.isPresent()) {
            FacturaKardex facKDb = facKOld.orElseThrow();
            facKDb.setArticulo(facturaK.getArticulo());
            facKDb.setFactura(facturaK.getFactura());
            facKDb.setFacKUni(facturaK.getFacKUni());
            facKDb.setFacKCtUni(facturaK.getFacKCtUni());
            facKDb.setFacKTtalVt(facturaK.getFacKTtalVt());
            facKDb.setFacKTtalCost(facturaK.getFacKTtalCost());

            return Optional.of(facturaKRepository.save(facturaK));
        }

        return Optional.empty();
    }

    
    @Override
    public Optional<FacturaKardex> delete(int facKCod) {
        Optional<FacturaKardex> facKOptional = facturaKRepository.findById(facKCod);
        facKOptional.ifPresent(facKDb -> {
            facturaKRepository.delete(facKDb);
        });
        return facKOptional;
    }
}
