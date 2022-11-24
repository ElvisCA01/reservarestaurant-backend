package com.reserva.restaurant.reservarestaurantbackend.services;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Usuario;
import com.reserva.restaurant.reservarestaurantbackend.modelos.UsuarioRol;

import java.util.Set;

public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception;

    public Usuario obtenerUsuario(String username);


    public void eliminarUsuario(Long usuarioId);
}
