package com.reserva.restaurant.reservarestaurantbackend.repositorios;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
