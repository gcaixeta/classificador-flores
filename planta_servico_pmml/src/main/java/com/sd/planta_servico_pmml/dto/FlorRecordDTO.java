package com.sd.planta_servico_pmml.dto;

public record FlorRecordDTO(
        double larguraSepala,
        double comprimentoSepala,
        double larguraPetala,
        double comprimentoPetala,
        String classifica
) {
}
