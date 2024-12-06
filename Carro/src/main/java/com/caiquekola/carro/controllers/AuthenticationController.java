package com.caiquekola.controllers;

import com.caiquekola.infra.security.TokenService;
import com.caiquekola.models.UserDomain.AuthenticationDTO;
import com.caiquekola.models.UserDomain.LoginResponse;
import com.caiquekola.models.UserDomain.RegisterDTO;
import com.caiquekola.models.UserDomain.User;
import com.caiquekola.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) authentication.getPrincipal());



        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO user) {
        if(this.userRepository.findByLogin(user.username()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
        User newUser = new User(user.username(),encryptedPassword,user.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}

