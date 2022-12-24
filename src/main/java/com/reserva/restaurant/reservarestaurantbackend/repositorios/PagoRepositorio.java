package com.reserva.restaurant.reservarestaurantbackend.repositorios;


import com.reserva.restaurant.reservarestaurantbackend.modelos.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepositorio extends JpaRepository<Pago, Long> {
}
