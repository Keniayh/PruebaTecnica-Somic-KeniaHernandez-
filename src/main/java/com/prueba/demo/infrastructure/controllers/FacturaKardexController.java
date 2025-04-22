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

import com.prueba.demo.application.services.IFacturaKardexService;
import com.prueba.demo.domain.entities.FacturaKardex;

@RestController
@RequestMapping("/facturaKardex")
public class FacturaKardexController {

    @Autowired
    private IFacturaKardexService facturaKardexService;

    @GetMapping
    public List<FacturaKardex> list() {
        return facturaKardexService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FacturaKardex facturaKardex) {
        FacturaKardex savedFacturaKardex = facturaKardexService.save(facturaKardex);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFacturaKardex);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int facKCod) {
        Optional<FacturaKardex> facturaKardexOptional = facturaKardexService.findById(facKCod);
        return facturaKardexOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int facKCod, @RequestBody FacturaKardex facturaKardex) {
        Optional<FacturaKardex> updatedFacturaKardexOptional = facturaKardexService.update(facKCod, facturaKardex);
        return updatedFacturaKardexOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
