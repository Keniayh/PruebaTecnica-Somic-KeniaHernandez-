package com.prueba.demo.infrastructure.repositories.articulo;

import com.prueba.demo.application.services.IArticuloService;
import com.prueba.demo.domain.entities.Articulo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloImpl implements IArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>)articuloRepository.findAll();
    }

    @Transactional
    @Override
    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Articulo> findById(int artCod) {
        return articuloRepository.findById(artCod);
    }

    @Transactional
    @Override
    public Optional<Articulo> update(int artCod, Articulo articulo) {
        Optional<Articulo> artOld = articuloRepository.findById(artCod);
        if(artOld.isPresent()) {
            Articulo artDb = artOld.orElseThrow();
            artDb.setArtNom(articulo.getArtNom());
            artDb.setArtLab(articulo.getArtLab());
            artDb.setArtCosto(articulo.getArtCosto());
            artDb.setArtSaldo(articulo.getArtSaldo());
            artDb.setArtPreVt(articulo.getArtPreVt());

            return Optional.of(articuloRepository.save(articulo));
        }

        return Optional.empty();
    }
}
