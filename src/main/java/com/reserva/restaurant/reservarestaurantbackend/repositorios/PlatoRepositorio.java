package com.reserva.restaurant.reservarestaurantbackend.repositorios;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepositorio extends JpaRepository<Plato, Integer> {
}
