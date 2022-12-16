package com.reserva.restaurant.reservarestaurantbackend.services.impl;

import com.reserva.restaurant.reservarestaurantbackend.excepciones.ResourceNotFoundException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Plato;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.PlatoRepositorio;
import com.reserva.restaurant.reservarestaurantbackend.services.PlatoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements PlatoService {

    private final PlatoRepositorio platoRepositorio;

    public PlatoServiceImpl(PlatoRepositorio platoRepositorio) {
        this.platoRepositorio = platoRepositorio;
    }

    @Override
    public Plato addPlato(Plato plato) {
        return platoRepositorio.save(plato);
    }

    @Override
    public Plato updatePlato(Plato plato) {
        return platoRepositorio.save(plato);
    }

    @Override
    public List<Plato> getPlato() {
        return platoRepositorio.findAll();
    }

    @Override
    public Plato obtenerPlatoPorId(Integer id){
        Optional<Plato> plato = platoRepositorio.findById(id);
        return plato.orElseThrow(() -> new ResourceNotFoundException("Plato no found"));
    }
    @Override
    public void deletePlato(Integer id) {
        platoRepositorio.deleteById(id);
    }
}
