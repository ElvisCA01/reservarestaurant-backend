package com.reserva.restaurant.reservarestaurantbackend.modelos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

    @Column(name = "papellido", length = 60, nullable = false)
    private String Papellido;

    @Column(name = "sapellido", length = 60, nullable = false)
    private String Sapellido;

    @Column(name = "horario", length = 60, nullable = false)
    private String horario;

    @Column(name = "evento", length = 60, nullable = false)
    private String evento;

    @Column(name="fecha", nullable = false, updatable = false)
    private String fecha;

    @Column(name="total", nullable = false)
    private Double total;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "reserva", fetch = FetchType.LAZY)
    private List<Orden> items;

}

