package com.reserva.restaurant.reservarestaurantbackend.validator;

import com.reserva.restaurant.reservarestaurantbackend.excepciones.IncorrectResourceRequestException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Orden;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Reserva;

public class ReservaValidator {

    public static void validate(Reserva reserva){
        if(reserva.getItems()==null || reserva.getItems().isEmpty()){
            throw new IncorrectResourceRequestException("item is null");
        }

        for(Orden line: reserva.getItems()){
            if(line.getPlato()==null || line.getPlato().getId()==null){
                throw new IncorrectResourceRequestException("plato is null");
            }
            if(line.getQuantity()<=0){
                throw new IncorrectResourceRequestException("cantidad 0");
            }
        }
    }

}
