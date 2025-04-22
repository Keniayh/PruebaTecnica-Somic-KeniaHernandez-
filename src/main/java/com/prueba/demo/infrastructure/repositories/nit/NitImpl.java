package com.prueba.demo.infrastructure.repositories.nit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.demo.application.services.INitService;
import com.prueba.demo.domain.entities.Nit;

@Service
public class NitImpl implements INitService{

    @Autowired
    private NitRepository nitRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Nit> findAll() {
        return (List<Nit>)nitRepository.findAll();
    }

    @Transactional
    @Override
    public Nit save(Nit nit) {
        return nitRepository.save(nit);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Nit> findById(int nitCod) {
        return nitRepository.findById(nitCod);
    }

    @Transactional
    @Override
    public Optional<Nit> update(int nitCod, Nit nit) {
        Optional<Nit> nitOld = nitRepository.findById(nitCod);
        if(nitOld.isPresent()) {
            Nit nitDb = nitOld.orElseThrow();
            nitDb.setNitNombre(nit.getNitNombre());
            nitDb.setNitDoc(nit.getNitDoc());
            nitDb.setNitCupo(nit.getNitCupo());
            nitDb.setNitPlazo(nit.getNitPlazo());
            nitDb.setNitCart(nit.getNitCart());
            nitDb.setNitDisp(nit.getNitDisp());

            return Optional.of(nitRepository.save(nit));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Nit> delete(int nitCod) {
        Optional<Nit> nitOptional = nitRepository.findById(nitCod);
        nitOptional.ifPresent(nitDb -> {
            nitRepository.delete(nitDb);
        });
        return nitOptional;
    }
}
