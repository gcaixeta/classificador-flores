package com.sd.planta_serv_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flor")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Double comprimentoSepala;

    @Column(nullable = false)
    private Double larguraSepala;

    @Column(nullable = false)
    private Double comprimentoPetala;

    @Column(nullable = false)
    private Double larguraPetala;

    @Column(nullable = false)
    private String especieTipo;

    @Column(nullable = false)
    private String cor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idplanta", nullable = false)
    private Planta planta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getComprimentoSepala() {
        return comprimentoSepala;
    }

    public void setComprimentoSepala(Double comprimentoSepala) {
        this.comprimentoSepala = comprimentoSepala;
    }

    public Double getLarguraSepala() {
        return larguraSepala;
    }

    public void setLarguraSepala(Double larguraSepala) {
        this.larguraSepala = larguraSepala;
    }

    public Double getComprimentoPetala() {
        return comprimentoPetala;
    }

    public void setComprimentoPetala(Double comprimentoPetala) {
        this.comprimentoPetala = comprimentoPetala;
    }

    public Double getLarguraPetala() {
        return larguraPetala;
    }

    public void setLarguraPetala(Double larguraPetala) {
        this.larguraPetala = larguraPetala;
    }

    public String getEspecieTipo() {
        return especieTipo;
    }

    public void setEspecieTipo(String especieTipo) {
        this.especieTipo = especieTipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}
