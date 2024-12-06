package com.caiquekola.models.CarroDomain;

import jakarta.persistence.*;
import lombok.*;

@Entity("Carros")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true, nullable = false)
    public String plate;

    public String model;

    public String color;

    public double tank;
}
