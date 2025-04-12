package com.prueba.demo.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.application.services.IArticuloService;
import com.prueba.demo.domain.entities.Articulo;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    @Autowired
    private IArticuloService articuloService;

    @GetMapping
    public List<Articulo> List() {
        return articuloService.findAll();
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Articulo articulo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(articuloService.save(articulo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int artCod) {
        Optional<Articulo> artOptional = articuloService.findById(artCod);
        return artOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int artCod, @RequestBody Articulo articulo) {
        Optional<Articulo> updateOptional = articuloService.update(artCod, articulo);
        return updateOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
