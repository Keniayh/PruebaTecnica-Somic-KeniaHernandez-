package com.prueba.demo.infrastructure.repositories.facturaKardex;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.demo.application.services.IFacturaKardexService;
import com.prueba.demo.domain.entities.Articulo;
import com.prueba.demo.domain.entities.FacturaKardex;
import com.prueba.demo.infrastructure.repositories.articulo.ArticuloRepository;

@Service
public class FacturaKardexImpl implements IFacturaKardexService {
    @Autowired
    private FacturaKardexRepository facturaKRepository;

    @Autowired
    private ArticuloRepository articuloRepository; // Repositorio de artículos para consultar y actualizar el saldo

    @Transactional(readOnly = true)
    @Override
    public List<FacturaKardex> findAll() {
        return (List<FacturaKardex>) facturaKRepository.findAll();
    }

    @Transactional
    @Override
    public FacturaKardex save(FacturaKardex facturaKardex) {
        // Validar el saldo del artículo antes de guardar
        validarSaldoArticulo(facturaKardex);
        validarModificacionCostos(facturaKardex);
        // Actualizar el saldo del artículo según la naturaleza
        actualizarSaldoArticulo(facturaKardex);
        facturaKardex.calcularTotalesDesdeArticulo();
        // Guardar el FacturaKardex después de la validación
        return facturaKRepository.save(facturaKardex);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<FacturaKardex> findById(int facKCod) {
        return facturaKRepository.findById(facKCod);
    }

    @Transactional
    @Override
    public Optional<FacturaKardex> update(int facKCod, FacturaKardex facturaK) {
        Optional<FacturaKardex> facKOld = facturaKRepository.findById(facKCod);
        if (facKOld.isPresent()) {
            FacturaKardex facKDb = facKOld.orElseThrow();
            facKDb.setArticulo(facturaK.getArticulo());
            facKDb.setFactura(facturaK.getFactura());
            facKDb.setFacKUni(facturaK.getFacKUni());
            facKDb.setFacKTtalVt(facturaK.getFacKTtalVt());
            facKDb.setFacKTtalCost(facturaK.getFacKTtalCost());

            facKDb.calcularTotalesDesdeArticulo();
            return Optional.of(facturaKRepository.save(facturaK));
        }

        return Optional.empty();
    }

    // Método para validar si el saldo del artículo es suficiente
    private void validarSaldoArticulo(FacturaKardex facturaKardex) {
        Articulo articulo = facturaKardex.getArticulo(); // Obtener el artículo desde FacturaKardex
        int unidadesSolicitadas = facturaKardex.getFacKUni(); // Unidades solicitadas en el FacturaKardex
        char naturaleza = facturaKardex.getFactura().getFacNatu(); // Naturaleza de la factura (+ o -)

        // Dependiendo de la naturaleza, validamos el saldo
        if (naturaleza == '-') {
            if (articulo.getArtSaldo() < unidadesSolicitadas) {
                throw new IllegalArgumentException("No hay suficiente stock para realizar la devolución.");
            }
        }
    }

    // Método para actualizar el saldo del artículo dependiendo de la naturaleza
    private void actualizarSaldoArticulo(FacturaKardex facturaKardex) {
        Articulo articulo = facturaKardex.getArticulo(); // Obtener el artículo desde FacturaKardex
        int unidadesSolicitadas = facturaKardex.getFacKUni(); // Unidades solicitadas en el FacturaKardex
        char naturaleza = facturaKardex.getFactura().getFacNatu(); // Naturaleza de la factura (+ o -)

        // Si la naturaleza es negativa, restamos las unidades del saldo
        if (naturaleza == '-') {
            articulo.setArtSaldo(articulo.getArtSaldo() + unidadesSolicitadas);
        } else if (naturaleza == '+') {
            // Si la naturaleza es positiva, sumamos las unidades al saldo
            articulo.setArtSaldo(articulo.getArtSaldo() - unidadesSolicitadas);
        }

        // Guardar los cambios en la base de datos
        articuloRepository.save(articulo);
    }

    // Validar que no se modifiquen los costos si la naturaleza es negativa
    private void validarModificacionCostos(FacturaKardex facturaKardex) {
        char naturaleza = facturaKardex.getFactura().getFacNatu();
        if (naturaleza == '-') { // Si es devolución
            // Aquí no permitimos modificar el costo o precio de venta
            if (facturaKardex.getFacKTtalVt() != null && facturaKardex.getFacKTtalVt().compareTo(BigDecimal.ZERO) > 0) {
                throw new IllegalArgumentException("No se puede modificar el precio de venta para una devolución.");
            }
            if (facturaKardex.getFacKTtalCost() != null && facturaKardex.getFacKTtalCost().compareTo(BigDecimal.ZERO) > 0) {
                throw new IllegalArgumentException("No se puede modificar el costo para una devolución.");
            }
        }
    }    
}
