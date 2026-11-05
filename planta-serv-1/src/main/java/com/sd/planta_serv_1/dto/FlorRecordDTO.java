package com.sd.planta_serv_1.dto;

public record FlorRecordDTO (
        Double comprimentoSepala,
        Double larguraSepala,
        Double comprimentoPetala,
        Double larguraPetala,
        String especieTipo,
        String cor,
        Long idPlanta
){
}
