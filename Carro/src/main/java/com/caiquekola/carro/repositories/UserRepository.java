package com.caiquekola.carro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.caiquekola.carro.models.User.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    public UserDetails findByLogin(String login);
}
