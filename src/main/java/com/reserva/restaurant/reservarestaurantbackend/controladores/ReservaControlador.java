package com.reserva.restaurant.reservarestaurantbackend.controladores;


import com.reserva.restaurant.reservarestaurantbackend.excepciones.ResourceNotFoundException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Reserva;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReservaControlador {

    @Autowired
    private ReservaRepositorio repositorio;


    //Este metodo sirve para listar las reservas
    @GetMapping("/reservas")
    public List<Reserva> listarTodasLasReservas() {
        return repositorio.findAll();
    }


    //Este metodo sirve para guardar las reservas
    @PostMapping("/reservas")
    public Reserva guardarReservas(@RequestBody Reserva reserva){
        return repositorio.save(reserva);
    }

    //Este metodo sirve para buscar una reserva por su id
    @GetMapping("/reservas/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id){
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe la reserva con la ID : " + id)));
        return ResponseEntity.ok(reserva);
    }

    //Este metodo actualizar la reserva
    @PutMapping("/reservas/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva detallesReserva){
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe la reserva con la ID : " + id)));
        reserva.setPersonas(detallesReserva.getPersonas());
        reserva.setNombre(detallesReserva.getNombre());
        reserva.setPapellido(detallesReserva.getPapellido());
        reserva.setSapellido(detallesReserva.getSapellido());
        reserva.setHorario(detallesReserva.getHorario());
        reserva.setEvento(detallesReserva.getEvento());
        reserva.setFecha(detallesReserva.getFecha());

        Reserva reservaActualizada = repositorio.save(reserva);
        return ResponseEntity.ok(reservaActualizada);
    }

    //Este metodo elimina la reserva
    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarReserva(@PathVariable Long id){
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe la reserva con la ID : " + id)));

                repositorio.delete(reserva);
                Map<String, Boolean> response = new HashMap<>();
                response.put("Eliminado",Boolean.TRUE);
                return ResponseEntity.ok(response);
    }
}
