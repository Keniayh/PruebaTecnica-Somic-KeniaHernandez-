package com.prueba.demo.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Articulos")
public class Articulo {
    @Id
    @Column(unique = true, name = "ArtCod")
    private int artCod;

    @Column(name = "ArtNom", length = 50)
    private String artNom;

    @Column(name = "ArtLab", length = 50)
    private String artLab;

    @Column(name = "ArtSaldo")
    private int artSaldo;

    @Column(name = "ArtCosto", precision = 10, scale = 2)
    private BigDecimal artCosto;
    
    @Column(name = "ArtPreVt", precision = 10, scale = 2)
    private BigDecimal artPreVt;

    public Articulo() {
    }

    public Articulo(int artCod, String artNom, String artLab, int artSaldo, BigDecimal artCosto, BigDecimal artPreVt) {
        this.artCod = artCod;
        this.artNom = artNom;
        this.artLab = artLab;
        this.artSaldo = artSaldo;
        this.artCosto = artCosto;
        this.artPreVt = artPreVt;
    }

    public int getArtCod() {
        return artCod;
    }

    public void setArtCod(int artCod) {
        this.artCod = artCod;
    }

    public String getArtNom() {
        return artNom;
    }

    public void setArtNom(String artNom) {
        this.artNom = artNom;
    }

    public String getArtLab() {
        return artLab;
    }

    public void setArtLab(String artLab) {
        this.artLab = artLab;
    }

    public int getArtSaldo() {
        return artSaldo;
    }

    public void setArtSaldo(int artSaldo) {
        this.artSaldo = artSaldo;
    }

    public BigDecimal getArtCosto() {
        return artCosto;
    }

    public void setArtCosto(BigDecimal artCosto) {
        this.artCosto = artCosto;
    }

    public BigDecimal getArtPreVt() {
        return artPreVt;
    }

    public void setArtPreVt(BigDecimal artPreVt) {
        this.artPreVt = artPreVt;
    }

}
