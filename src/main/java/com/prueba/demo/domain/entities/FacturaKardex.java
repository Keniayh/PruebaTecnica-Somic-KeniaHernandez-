package com.prueba.demo.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "FacturaKardex")
public class FacturaKardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FacKCod")
    private int facKCod;

    @ManyToOne
    @JoinColumn(name = "FacCod", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "ArtCod", nullable = false)
    private Articulo articulo;

    @Column(name = "FacKUni")
    private int facKUni;


    @Column(name = "FacKCtUni")
    private BigDecimal facKCtUni;

    @Column(name = "FacKTtalVt", precision = 10, scale = 2)
    private BigDecimal facKTtalVt;

    @Column(name = "FacKTtalCost", precision = 10, scale = 2)
    private BigDecimal facKTtalCost;

    public FacturaKardex() {
    }

    public FacturaKardex(int facKCod, Factura factura, Articulo articulo, int facKUni, BigDecimal facKCtUni,
            BigDecimal facKTtalVt, BigDecimal facKTtalCost) {
        this.facKCod = facKCod;
        this.factura = factura;
        this.articulo = articulo;
        this.facKUni = facKUni;
        this.facKCtUni = facKCtUni;
        this.facKTtalVt = facKTtalVt;
        this.facKTtalCost = facKTtalCost;
    }

    public int getFacKCod() {
        return facKCod;
    }

    public void setFacKCod(int facKCod) {
        this.facKCod = facKCod;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getFacKUni() {
        return facKUni;
    }

    public void setFacKUni(int facKUni) {
        this.facKUni = facKUni;
    }

    public BigDecimal getFacKCtUni() {
        return facKCtUni;
    }

    public void setFacKCtUni(BigDecimal facKCtUni) {
        this.facKCtUni = facKCtUni;
    }

    public BigDecimal getFacKTtalVt() {
        return facKTtalVt;
    }

    public void setFacKTtalVt(BigDecimal facKTtalVt) {
        this.facKTtalVt = facKTtalVt;
    }

    public BigDecimal getFacKTtalCost() {
        return facKTtalCost;
    }

    public void setFacKTtalCost(BigDecimal facKTtalCost) {
        this.facKTtalCost = facKTtalCost;
    }

    public void calcularTotalesDesdeArticulo() {
        if (articulo != null && facKUni > 0) {
            this.facKTtalVt = articulo.getArtPreVt().multiply(BigDecimal.valueOf(facKUni));
            this.facKTtalCost = articulo.getArtCosto().multiply(BigDecimal.valueOf(facKUni));
        }
    }
    
}

