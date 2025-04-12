package com.prueba.demo.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FacCod")
    private int facCod;

    @ManyToOne
    @JoinColumn(name = "NitCod", nullable = false)
    private Nit nit;

    @Column(name = "FacFecha")
    private LocalDate facFecha;

    @Column(name = "FacVenc")
    private LocalDate facVenc;

    @Column(name = "FacNatu", length = 1)
    private char facNatu; // '+' o '-'

    @Column(name = "FacTtalVt", precision = 10, scale = 2)
    private BigDecimal facTtalVt;

    @Column(name = "FacTtalCost", precision = 10, scale = 2)
    private BigDecimal facTtalCost;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturaKardex> kardex;

    public Factura() {
    }

    public Factura(int facCod, Nit nit, LocalDate facFecha, LocalDate facVenc, char facNatu, BigDecimal facTtalVt,
            BigDecimal facTtalCost, List<FacturaKardex> kardex) {
        this.facCod = facCod;
        this.nit = nit;
        this.facFecha = facFecha;
        this.facVenc = facVenc;
        this.facNatu = facNatu;
        this.facTtalVt = facTtalVt;
        this.facTtalCost = facTtalCost;
        this.kardex = kardex;
    }

    public int getFacCod() {
        return facCod;
    }

    public void setFacCod(int facCod) {
        this.facCod = facCod;
    }

    public Nit getNit() {
        return nit;
    }

    public void setNit(Nit nit) {
        this.nit = nit;
    }

    public LocalDate getFacFecha() {
        return facFecha;
    }

    public void setFacFecha(LocalDate facFecha) {
        this.facFecha = facFecha;
    }

    public LocalDate getFacVenc() {
        return facVenc;
    }

    public void setFacVenc(LocalDate facVenc) {
        this.facVenc = facVenc;
    }

    public char getFacNatu() {
        return facNatu;
    }

    public void setFacNatu(char facNatu) {
        this.facNatu = facNatu;
    }

    public BigDecimal getFacTtalVt() {
        return facTtalVt;
    }

    public void setFacTtalVt(BigDecimal facTtalVt) {
        this.facTtalVt = facTtalVt;
    }

    public BigDecimal getFacTtalCost() {
        return facTtalCost;
    }

    public void setFacTtalCost(BigDecimal facTtalCost) {
        this.facTtalCost = facTtalCost;
    }

    public List<FacturaKardex> getKardex() {
        return kardex;
    }

    public void setKardex(List<FacturaKardex> kardex) {
        this.kardex = kardex;
    }

    public void calcularTotales() {
        BigDecimal totalVenta = BigDecimal.ZERO;
        BigDecimal totalCosto = BigDecimal.ZERO;
    
        // Iterar sobre FacturaKardex
        for (FacturaKardex kardex : this.kardex) {
            if (kardex.getFacKTtalVt() != null) {
                totalVenta = totalVenta.add(kardex.getFacKTtalVt());
            }
            if (kardex.getFacKTtalCost() != null) {
                totalCosto = totalCosto.add(kardex.getFacKTtalCost());
            }
        }
    
        // Asignar los totales calculados
        this.facTtalVt = totalVenta;
        this.facTtalCost = totalCosto;
    }
    
    public void calcularFechaVencimiento() {
        if (this.facFecha != null && this.nit != null) {
            // Sumamos los días de plazo a la fecha de la factura
            this.facVenc = this.facFecha.plusDays(nit.getNitPlazo());
        }
    }
}

