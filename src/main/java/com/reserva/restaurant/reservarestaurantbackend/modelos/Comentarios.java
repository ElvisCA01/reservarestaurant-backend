package com.reserva.restaurant.reservarestaurantbackend.modelos;


import javax.persistence.*;

@Entity
@Table(name = "Comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Nombre", nullable = false, length = 60)
    private String nombre;

    @Column(name="Comentario",nullable = false)
    private String comentario;

    public  Comentarios(){

    }

    public Comentarios(Long id, String nombre, String comentario) {
        this.id = id;
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
