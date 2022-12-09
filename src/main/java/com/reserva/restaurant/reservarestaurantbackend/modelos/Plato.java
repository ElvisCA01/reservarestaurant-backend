package com.reserva.restaurant.reservarestaurantbackend.modelos;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "platos")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categoria", length = 60, nullable = false)
    private String categoria;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "price", nullable = false)
    private Double price;

}
