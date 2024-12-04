package com.caiquekola.carro.infra.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.caiquekola.carro.models.User.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {


    public String generateToken(User user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256("carros");
        }catch (Exception e){

        }
        return "";
    }
}
