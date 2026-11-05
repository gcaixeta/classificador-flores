package com.sd.planta_servico_gestor.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> getPlantas() {
        return restTemplate.getForEntity(url_serv1_plantas, String.class);
    }

    public ResponseEntity<String> salvarPlanta(RequestEntity<String> planta) {
        return restTemplate.postForEntity(url_serv1_plantas, planta, String.class);
    }

    public void deletarPlanta(RequestEntity<String> planta) {
        restTemplate.exchange(url_serv1_plantas, HttpMethod.DELETE, planta, String.class);
    }

    public ResponseEntity<String> getFlores() {
        return restTemplate.getForEntity(url_serv1_flores, String.class);
    }

    public ResponseEntity<String> salvarFlor(RequestEntity<String> flor) {
        return restTemplate.postForEntity(url_serv1_flores, flor, String.class);
    }

    public void deletarFlor(RequestEntity<String> flor) {
        restTemplate.exchange(url_serv1_flores, HttpMethod.DELETE, flor, String.class);
    }

    public ResponseEntity<String> classificar(RequestEntity<String> dadosFlor) {
        return restTemplate.postForEntity(url_servPmml, dadosFlor, String.class);
    }
}
