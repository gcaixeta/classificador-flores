package com.sd.planta_serv_1.service;

import com.sd.planta_serv_1.dto.FlorRecordDTO;
import com.sd.planta_serv_1.model.Flor;
import com.sd.planta_serv_1.model.Planta;
import com.sd.planta_serv_1.repository.FlorRepository;
import com.sd.planta_serv_1.repository.PlantaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlorService {

    private final PlantaRepository plantas;
    private final FlorRepository flores;

    public FlorService(PlantaRepository plantas, FlorRepository flores) {
        this.plantas = plantas;
        this.flores = flores;
    }

    public List<Flor> getFlores() {
        return flores.findAll();
    }

    public Flor salvarFlor(FlorRecordDTO flor) {
        Flor novaFlor = new Flor();
        novaFlor.setComprimentoPetala(flor.comprimentoPetala());
        novaFlor.setLarguraPetala(flor.larguraPetala());
        novaFlor.setComprimentoSepala(flor.comprimentoSepala());
        novaFlor.setLarguraSepala(flor.larguraSepala());
        novaFlor.setEspecieTipo(flor.especieTipo());
        novaFlor.setCor(flor.cor());
        novaFlor.setPlanta(plantas.findById(flor.idPlanta()).orElseThrow(EntityNotFoundException::new));
        return flores.save(novaFlor);
    }

    public void excluirFlor(Flor flor) {
        flores.deleteById(flor.getId());
    }

    public Flor getFlorById(Long id) {
        return flores.findById(id).orElseThrow(EntityNotFoundException);
    }
}
