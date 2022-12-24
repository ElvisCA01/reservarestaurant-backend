package com.reserva.restaurant.reservarestaurantbackend.services.impl;

import com.reserva.restaurant.reservarestaurantbackend.excepciones.ResourceNotFoundException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Pago;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.PagoRepositorio;
import com.reserva.restaurant.reservarestaurantbackend.services.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepositorio pagoRepositorio;

    public PagoServiceImpl(PagoRepositorio pagoRepositorio) {
        this.pagoRepositorio = pagoRepositorio;
    }

    @Override
    public Pago addPago(Pago pago) {
        return pagoRepositorio.save(pago);
    }

    @Override
    public Pago updatePago(Pago pago) {
        return pagoRepositorio.save(pago);
    }

    @Override
    public List<Pago> getPago() {
        return pagoRepositorio.findAll();
    }

    @Override
    public Pago obtenerPagoPorId(Long id) {
        Optional<Pago> pago = pagoRepositorio.findById(id);
        return pago.orElseThrow(() -> new ResourceNotFoundException("Pago no found"));
    }

    @Override
    public void deletePago(Long id) {
        pagoRepositorio.deleteById(id);
    }
}
