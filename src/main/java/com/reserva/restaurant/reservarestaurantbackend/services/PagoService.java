package com.reserva.restaurant.reservarestaurantbackend.services;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Pago;

import java.util.List;

public interface PagoService {

    Pago addPago(Pago pago);
    Pago updatePago(Pago pago);
    List<Pago> getPago();
    Pago obtenerPagoPorId(Long id);
    void deletePago(Long id);

}
