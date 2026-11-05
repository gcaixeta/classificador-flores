package com.sd.planta_servico_gestor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SistemasService {

    private RestTemplate restTemplate;
    private String url_serv1_flores;
    private String url_serv1_plantas;
    private String url_servPmml;

    public SistemasService() {
        restTemplate = new RestTemplate();
        url_serv1_flores = "http://localhost:8081/api/flores";
        url_serv1_plantas = "http://localhost:8081/api/plantas";
        url_servPmml = "http://localhost:8083/api/pmml";
    }
}
