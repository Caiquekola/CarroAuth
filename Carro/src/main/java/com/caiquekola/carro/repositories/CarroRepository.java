package com.caiquekola.carro.repositories;

import com.caiquekola.carro.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
