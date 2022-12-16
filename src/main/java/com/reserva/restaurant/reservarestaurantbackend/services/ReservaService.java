package com.reserva.restaurant.reservarestaurantbackend.services;

import com.reserva.restaurant.reservarestaurantbackend.excepciones.ResourceNotFoundException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Orden;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Plato;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Reserva;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.PlatoRepositorio;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.ReservaRepositorio;
import com.reserva.restaurant.reservarestaurantbackend.validator.ReservaValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepositorio reservaRepositorio;
    private final PlatoRepositorio platoRepositorio;

    public ReservaService(ReservaRepositorio reservaRepositorio, PlatoRepositorio platoRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
        this.platoRepositorio = platoRepositorio;
    }

    @Transactional
    public Reserva crearReserva(Reserva reserva){
        ReservaValidator.validate(reserva);
        double total=0;
        for(Orden item:reserva.getItems()){
            Plato plato = platoRepositorio.findById(item.getPlato().getId())
                    .orElseThrow(()->new ResourceNotFoundException("No existe el plato "+item.getPlato().getId()));

            item.setPrice(plato.getPrice());
            item.setTotal(plato.getPrice()*item.getQuantity());
            total+= item.getTotal();
        }
        reserva.setTotal(total);
        reserva.getItems().forEach(line->line.setReserva(reserva));
        reserva.setFecha(LocalDate.now());
        return reservaRepositorio.save(reserva);
    }

    @Transactional(readOnly = true)
    public List<Reserva> obtenerReservas(){
        return reservaRepositorio.findAll();
    }

    @Transactional
    public void deleteReserva(Long id){
        reservaRepositorio.deleteById(id);
    }

    public Reserva obtenerReservaPorId(Long id){
        Optional<Reserva> reserva = reservaRepositorio.findById(id);
        return reserva.orElseThrow(() -> new ResourceNotFoundException("Reserva no found"));
    }

}
