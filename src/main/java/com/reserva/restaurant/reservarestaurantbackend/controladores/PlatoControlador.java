package com.reserva.restaurant.reservarestaurantbackend.controladores;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Plato;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Reserva;
import com.reserva.restaurant.reservarestaurantbackend.services.PlatoService;
import com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
@CrossOrigin(origins = "*")
public class PlatoControlador {
    private final PlatoService platoService;

    public PlatoControlador(PlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping
    public ResponseEntity<Plato> addPlato(@RequestBody Plato plato){
        Plato newPlato = platoService.addPlato(plato);
        return new ResponseEntity<Plato>(newPlato, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Plato> updatePlato(@RequestBody Plato plato){
        Plato updatePlato = platoService.updatePlato(plato);
        return new ResponseEntity<Plato>(updatePlato, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public List<Plato> getPlato(){
        return platoService.getPlato();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<Plato>> obtenerPlatoPorId(@PathVariable("id") Integer id){
        Plato plato = platoService.obtenerPlatoPorId(id);
        return new WrapperResponse<>(true, "success", plato).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlato(@PathVariable("id") Integer id){
        platoService.deletePlato(id);
        return new ResponseEntity<String >("Plato eliminado", HttpStatus.OK);
    }

}
