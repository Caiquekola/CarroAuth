package com.caiquekola.carro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.caiquekola.carro.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public void findByLogin(String login);
}
