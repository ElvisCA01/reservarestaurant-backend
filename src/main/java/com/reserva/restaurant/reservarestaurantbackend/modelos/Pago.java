package com.reserva.restaurant.reservarestaurantbackend.modelos;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titular", length = 60, nullable = false)
    private String titular;

    @Column(name = "tipo", length = 60, nullable = false)
    private String tipo;

    @Column(name = "numero", length = 60, nullable = false)
    private String numero;

    @Column(name = "fechaCaducidad", length = 60, nullable = false)
    private String fechaCaducidad;

    @Column(name = "cvv", length = 60, nullable = false)
    private String cvv;

}
