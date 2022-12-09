package com.reserva.restaurant.reservarestaurantbackend.services.impl;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Plato;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.PlatoRepositorio;
import com.reserva.restaurant.reservarestaurantbackend.services.PlatoService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void deletePlato(Integer id) {
        platoRepositorio.deleteById(id);
    }
}
