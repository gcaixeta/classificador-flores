package com.sd.planta_servico_pmml.controller;

import com.sd.planta_servico_pmml.dto.ClasseRecordDTO;
import com.sd.planta_servico_pmml.dto.FlorRecordDTO;
import com.sd.planta_servico_pmml.service.ClassificarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pmml")
public class ClassificarController {

    @Autowired
    private ClassificarService service;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ClasseRecordDTO salvarClassificar(@RequestBody FlorRecordDTO dto) {
        return service.classificar(dto);
    }
}
