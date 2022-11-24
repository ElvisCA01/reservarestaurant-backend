package com.reserva.restaurant.reservarestaurantbackend.services.impl;

import com.reserva.restaurant.reservarestaurantbackend.excepciones.UsuarioFoundException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Usuario;
import com.reserva.restaurant.reservarestaurantbackend.modelos.UsuarioRol;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.RolRepositorio;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.UsuarioRepositorio;
import com.reserva.restaurant.reservarestaurantbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepositorio.findByUsername(usuario.getUsername());
        if (usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }else{
            for (UsuarioRol usuarioRol:usuariosRoles){
                rolRepositorio.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuariosRoles);
            usuarioLocal = usuarioRepositorio.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepositorio.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepositorio.deleteById(usuarioId);
    }


}
