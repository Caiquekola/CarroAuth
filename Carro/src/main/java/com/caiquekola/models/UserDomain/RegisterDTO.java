package com.caiquekola.models.UserDomain;

public record RegisterDTO(String username, String password, UserRole role) {
}
