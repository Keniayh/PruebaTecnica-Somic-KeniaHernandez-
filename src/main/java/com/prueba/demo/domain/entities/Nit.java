package com.prueba.demo.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name= "nit")
public class Nit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NitCod")
    private int nitCod;

    @Column(length = 50, name = "NitNom")
    private String nitNombre;

    @Column(length = 11, unique = true, name = "NitDoc")
    private String nitDoc;

    @Column(length = 20, name = "NitCupo")
    private BigDecimal nitCupo;

    @Column(name = "NitPlazo")
    private int nitPlazo;

    @Column(name = "NitCart", precision = 10, scale = 2)
    private BigDecimal nitCart;

    @Column(name = "NitDisp", precision = 10, scale = 2)
    private BigDecimal nitDisp;

    public Nit() {
    }

    public Nit(int nitCod, String nitNombre, String nitDoc, BigDecimal nitCupo, int nitPlazo, BigDecimal nitCart,
            BigDecimal nitDisp) {
        this.nitCod = nitCod;
        this.nitNombre = nitNombre;
        this.nitDoc = nitDoc;
        this.nitCupo = nitCupo;
        this.nitPlazo = nitPlazo;
        this.nitCart = nitCart;
        this.nitDisp = nitDisp;
    }

    public int getNitCod() {
        return nitCod;
    }

    public void setNitCod(int nitCod) {
        this.nitCod = nitCod;
    }

    public String getNitNombre() {
        return nitNombre;
    }

    public void setNitNombre(String nitNombre) {
        this.nitNombre = nitNombre;
    }

    public String getNitDoc() {
        return nitDoc;
    }

    public void setNitDoc(String nitDoc) {
        this.nitDoc = nitDoc;
    }

    public BigDecimal getNitCupo() {
        return nitCupo;
    }

    public void setNitCupo(BigDecimal nitCupo) {
        this.nitCupo = nitCupo;
    }

    public int getNitPlazo() {
        return nitPlazo;
    }

    public void setNitPlazo(int nitPlazo) {
        this.nitPlazo = nitPlazo;
    }

    public BigDecimal getNitCart() {
        return nitCart;
    }

    public void setNitCart(BigDecimal nitCart) {
        this.nitCart = nitCart;
    }

    public BigDecimal getNitDisp() {
        return nitDisp;
    }

    public void setNitDisp(BigDecimal nitDisp) {
        this.nitDisp = nitDisp;
    }
}
