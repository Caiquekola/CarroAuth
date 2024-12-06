package com.caiquekola.repositories;

import com.caiquekola.models.CarroDomain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
