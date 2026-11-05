package com.sd.planta_servico_gestor.controller;

import com.sd.planta_servico_gestor.service.SistemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SistemasController {

    @Autowired
    private SistemasService service;

    @GetMapping("/plantas")
    public ResponseEntity<String> getPlantas() {
        return service.getPlantas();
    }

    @PostMapping("/plantas")
    public ResponseEntity<String> salvarPlanta(RequestEntity<String> planta) {
        return service.salvarPlanta(planta);
    }

    @DeleteMapping("/plantas")
    public void deletarPlanta(RequestEntity<String> planta) {
        service.deletarPlanta(planta);
    }

    @GetMapping("/flores")
    public ResponseEntity<String> getFlores() {
        return service.getFlores();
    }

    @PostMapping("/flores")
    public ResponseEntity<String> salvarFlor(RequestEntity<String> flor) {
        return service.salvarFlor(flor);
    }

    @DeleteMapping("/flores")
    public void deletarFlor(RequestEntity<String> flor) {
        service.deletarFlor(flor);
    }

    @PostMapping("/classificar")
    public ResponseEntity<String> classificar(RequestEntity<String> dadosFlor) {
        return service.classificar(dadosFlor);
    }
}
