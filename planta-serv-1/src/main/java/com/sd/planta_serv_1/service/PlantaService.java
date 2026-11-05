package com.sd.planta_serv_1.service;

import com.sd.planta_serv_1.model.Planta;
import com.sd.planta_serv_1.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaService {

    private final PlantaRepository plantas;

    public PlantaService(PlantaRepository plantas) {
        this.plantas = plantas;
    }

    public List<Planta> getPlantas() {
        return plantas.findAll();
    }

    public Planta salvarPlanta(Planta planta) {
        return plantas.save(planta);
    }

    public void excluirPlanta(Planta planta) {
        plantas.deleteById(planta.getId());
    }
}
