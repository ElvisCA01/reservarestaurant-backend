package com.reserva.restaurant.reservarestaurantbackend.repositorios;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepositorio extends JpaRepository<Comentarios, Long> {
}
