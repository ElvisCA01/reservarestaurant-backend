package com.reserva.restaurant.reservarestaurantbackend.controladores;


import com.reserva.restaurant.reservarestaurantbackend.excepciones.ResourceNotFoundException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Comentarios;
import com.reserva.restaurant.reservarestaurantbackend.repositorios.ComentariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comentariosB/")
@CrossOrigin(origins = "*")
public class ComentariosControlador {

    @Autowired
    private ComentariosRepositorio comentariosRepositorio;


    @GetMapping("/comentarios")
    public List<Comentarios> listarComentarios(){
        return comentariosRepositorio.findAll();
    }

    @PostMapping("/comentarios")
    public Comentarios guardarComentario(@RequestBody Comentarios comentarios){
        return comentariosRepositorio.save(comentarios);
    }
    @GetMapping("/comentarios/{id}")
    public ResponseEntity<Comentarios> obtenerComentarioPorId(@PathVariable Long id){
        Comentarios comentarios = comentariosRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese comentario o ya ha sido eliminado"));
        return ResponseEntity.ok(comentarios);
    }

    @PutMapping("/comentarios/{id}")
    public ResponseEntity<Comentarios> actualizarComentario(@PathVariable Long id,@RequestBody Comentarios datosComentario){
        Comentarios comentarios = comentariosRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ese comentario o ya ha sido eliminado"));
        comentarios.setNombre(datosComentario.getNombre());
        comentarios.setComentario(datosComentario.getComentario());

        Comentarios comentariosActualizado = comentariosRepositorio.save(comentarios);
        return ResponseEntity.ok(comentarios);
    }

    @DeleteMapping("/comentarios/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarComentario(@PathVariable Long id){
       Comentarios comentarios = comentariosRepositorio.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("No existe ese comentario o ya ha sido eliminado"));
       comentariosRepositorio.delete(comentarios);
       Map<String, Boolean> respuesta = new HashMap<>();
       respuesta.put("Eliminar", Boolean.TRUE);
       return ResponseEntity.ok(respuesta);
    }

}
