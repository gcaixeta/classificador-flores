package com.sd.planta_servico_pmml.service;

import com.sd.planta_servico_pmml.dto.ClasseRecordDTO;
import com.sd.planta_servico_pmml.dto.FlorRecordDTO;
import org.pmml4s.model.Model;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClassificarService {
    private static final String arquivoSvm = "home/mitya/Projects/sdiftm/plantas/pmml/knimeSvmIris.pmml";
    private static final String arquivoDTree = "home/mitya/Projects/sdiftm/plantas/pmml/knimeDtIris.pmml";

    public ClasseRecordDTO classificar(FlorRecordDTO flor) {

        FileInputStream is = null;
        Map<String, Object> saida = null;
        try {
            if (flor.classifica().toLowerCase().equals("svm")){
                is = new FileInputStream(arquivoSvm);
            } else if (flor.classifica().toLowerCase().equals("decision tree")) {
                is = new FileInputStream(arquivoDTree);
            } else {
                is = new FileInputStream(arquivoDTree);
            }

            Model model = Model.fromInputStream(is);

            saida = model.predict(new HashMap<>() {{
                put("SepalLengthCm", flor.comprimentoSepala());
                put("SepalWidthCm", flor.larguraSepala());
                put("PetalLengthCm", flor.larguraPetala());
                put("PetalWidthCm", flor.larguraPetala());
            }});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String classe = saida.get("predicted_Species").toString();
        if (classe.contains("-")) classe = classe.replace("-", "");
        if (classe.contains("Iris")) classe = classe.replaceAll("Iris", "");

        return new ClasseRecordDTO(classe);
    }
}
