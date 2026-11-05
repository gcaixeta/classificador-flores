package com.sd.planta_serv_1;

import com.sd.planta_serv_1.model.Planta;
import com.sd.planta_serv_1.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/plantas")
public class PlantaController {

    @Autowired
    private PlantaService plantaService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Planta>> getPlantas() {
        return ResponseEntity.ok(plantaService.getPlantas());
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Planta> salvarPlanta(@RequestBody Planta planta) {
        return ResponseEntity.ok(plantaService.salvarPlanta(planta));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    public void excluirPlanta(@RequestBody Planta planta) {
        plantaService.excluirPlanta(planta);
    }
}
