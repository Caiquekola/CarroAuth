package com.caiquekola.controllers;

import com.caiquekola.models.CarroDomain.Carro;
import com.caiquekola.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroRepository carroRepository;

    @GetMapping()
    public List<Carro> home() {
        return carroRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addCarro(@RequestBody  Carro carro) {
        carroRepository.save(carro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
