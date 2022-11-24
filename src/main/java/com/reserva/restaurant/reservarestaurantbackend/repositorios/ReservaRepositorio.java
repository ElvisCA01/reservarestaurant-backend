package com.reserva.restaurant.reservarestaurantbackend.repositorios;


import com.reserva.restaurant.reservarestaurantbackend.modelos.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

}
