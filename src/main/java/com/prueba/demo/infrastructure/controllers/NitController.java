package com.prueba.demo.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.application.services.INitService;
import com.prueba.demo.domain.entities.Nit;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/nits")
public class NitController {
    @Autowired
    private INitService nitService;

    @GetMapping
    public List<Nit> List() {
        return nitService.findAll();
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Nit nit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nitService.save(nit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int nitCod) {
        Optional<Nit> nitOptional = nitService.findById(nitCod);
        return nitOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int nitCod, @RequestBody Nit nit) {
        Optional<Nit> updateOptional = nitService.update(nitCod, nit);
        return updateOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
