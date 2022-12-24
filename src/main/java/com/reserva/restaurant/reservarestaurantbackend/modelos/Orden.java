package com.reserva.restaurant.reservarestaurantbackend.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="quantity", nullable = false)
    private Double quantity;

    @Column(name="total", nullable = false)
    private Double total;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false, foreignKey = @ForeignKey(name = "FK_reserva_orden"))
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "platos_id", nullable = false, foreignKey = @ForeignKey(name = "FK_platos_orden"))
    private Plato plato;

}
