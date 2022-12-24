package com.reserva.restaurant.reservarestaurantbackend.controladores;

import com.reserva.restaurant.reservarestaurantbackend.modelos.Pago;
import com.reserva.restaurant.reservarestaurantbackend.services.impl.PagoServiceImpl;
import com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "*")
public class PagoControlador {

    private final PagoServiceImpl pagoService;

    public PagoControlador(PagoServiceImpl pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<Pago> addPago(@RequestBody Pago pago){
        Pago newPago = pagoService.addPago(pago);
        return new ResponseEntity<Pago>(newPago, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pago> updatePago(@RequestBody Pago pago){
        Pago updatePago = pagoService.updatePago(pago);
        return new ResponseEntity<Pago>(updatePago, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public List<Pago> getPlato(){
        return pagoService.getPago();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<Pago>> obtenerPlatoPorId(@PathVariable("id") Long id){
        Pago pago = pagoService.obtenerPagoPorId(id);
        return new WrapperResponse<>(true, "success", pago).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlato(@PathVariable("id") Long id){
        pagoService.deletePago(id);
        return new ResponseEntity<String >("Pago eliminado", HttpStatus.OK);
    }

}
