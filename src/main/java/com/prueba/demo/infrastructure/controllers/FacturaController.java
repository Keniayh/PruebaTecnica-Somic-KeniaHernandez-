package com.prueba.demo.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.application.services.IFacturaService;
import com.prueba.demo.domain.entities.Factura;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping
    public List<Factura> list() {
        return facturaService.findAll();
    }

    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Factura factura) {
        Factura savedFactura = facturaService.save(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFactura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int facCod) {
        Optional<Factura> facturaOptional = facturaService.findById(facCod);
        return facturaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int facCod, @RequestBody Factura factura) {
        Optional<Factura> updatedFacturaOptional = facturaService.update(facCod, factura);
        return updatedFacturaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{facCod}")
    public ResponseEntity<?> delete(@PathVariable int facCod) {
        Optional<Factura> nitDelete = facturaService.delete(facCod);
        return nitDelete.map(c -> ResponseEntity.ok().build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

