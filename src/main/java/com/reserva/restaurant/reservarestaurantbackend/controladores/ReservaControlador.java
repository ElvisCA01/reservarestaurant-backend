package com.reserva.restaurant.reservarestaurantbackend.controladores;


import com.reserva.restaurant.reservarestaurantbackend.modelos.Reserva;
import com.reserva.restaurant.reservarestaurantbackend.services.ReservaService;
import com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "*")
public class ReservaControlador {

    private final ReservaService reservaService;

    public ReservaControlador(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Reserva>> agregarReserva(@RequestBody Reserva reserva){
        Reserva newReserva = reservaService.crearReserva(reserva);
        return new WrapperResponse<>(true,"success",newReserva).createResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> deleteReserva(@PathVariable("id") Long id){
        reservaService.deleteReserva(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listar")
    public List<Reserva> listarReservas(){
        return reservaService.obtenerReservas();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<Reserva>> obtenerReservaPorId(@PathVariable("id") Long id){
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        return new WrapperResponse<>(true, "success", reserva).createResponse(HttpStatus.OK);
    }

}
