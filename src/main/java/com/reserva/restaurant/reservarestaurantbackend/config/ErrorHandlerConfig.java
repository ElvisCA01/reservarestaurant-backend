package com.reserva.restaurant.reservarestaurantbackend.config;

import com.reserva.restaurant.reservarestaurantbackend.excepciones.GeneralServiceException;
import com.reserva.restaurant.reservarestaurantbackend.excepciones.IncorrectResourceRequestException;
import com.reserva.restaurant.reservarestaurantbackend.excepciones.ResourceNotFoundException;
import com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getAllErrors().stream().map(e -> {
            return e.getDefaultMessage().toString().concat(", ");
        }).collect(Collectors.joining());
        WrapperResponse<?> response = new WrapperResponse<>(false, message, null);
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse<?>> all(Exception e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(false, "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IncorrectResourceRequestException.class)
    public ResponseEntity<com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse<?>> validateServiceException(IncorrectResourceRequestException e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse<?>> noDataFoundException(ResourceNotFoundException e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<com.reserva.restaurant.reservarestaurantbackend.util.WrapperResponse<?>> generalServiceException(GeneralServiceException e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(false, "Internal Server Error", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
