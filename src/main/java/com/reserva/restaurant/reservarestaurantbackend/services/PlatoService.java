package com.reserva.restaurant.reservarestaurantbackend.services;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Plato;

import java.util.List;

public interface PlatoService {
    Plato addPlato(Plato plato);
    Plato updatePlato(Plato plato);
    List<Plato> getPlato();

    Plato obtenerPlatoPorId(Integer id);
    void deletePlato(Integer id);
}
