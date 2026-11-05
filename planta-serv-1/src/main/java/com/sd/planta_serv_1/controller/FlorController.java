package com.sd.planta_serv_1.controller;

import com.sd.planta_serv_1.dto.FlorRecordDTO;
import com.sd.planta_serv_1.model.Flor;
import com.sd.planta_serv_1.repository.FlorRepository;
import com.sd.planta_serv_1.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flores")
public class FlorController {

    @Autowired
    private FlorService florService;

    @GetMapping
    public List<Flor> getFlores() {
        return florService.getFlores();
    }

    @GetMapping("/{id}")
    public Flor getFlor(@PathVariable Long id) {
        return florService.getFlorById(id);
    }

    @PostMapping
    public Flor salvarFlor(@RequestBody FlorRecordDTO flor) {
        return florService.salvarFlor(flor);
    }

    @DeleteMapping
    public void excluirFlor(@RequestBody Flor flor) {
        florService.excluirFlor(flor);
    }
}
