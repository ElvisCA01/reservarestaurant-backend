package com.reserva.restaurant.reservarestaurantbackend.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "personas", length = 60, nullable = false)
    private String personas;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "Papellido", length = 60, nullable = false)
    private String Papellido;

    @Column(name = "Sapellido", length = 60, nullable = false)
    private String Sapellido;

    @Column(name = "horario", length = 60, nullable = false)
    private String horario;

    @Column(name = "evento", length = 60, nullable = false)
    private String evento;

    @Column(name = "fecha", length = 60, nullable = false)
    private Date fecha;

    public Reserva() {

    }

    public Reserva(long id, String personas, String nombre, String papellido, String sapellido, String horario, String evento, Date fecha) {
        this.id = id;
        this.personas = personas;
        this.nombre = nombre;
        Papellido = papellido;
        Sapellido = sapellido;
        this.horario = horario;
        this.evento = evento;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPapellido() {
        return Papellido;
    }

    public void setPapellido(String papellido) {
        Papellido = papellido;
    }

    public String getSapellido() {
        return Sapellido;
    }

    public void setSapellido(String sapellido) {
        Sapellido = sapellido;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

