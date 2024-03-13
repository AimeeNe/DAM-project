package com.avl.damback.services.auth;


import com.avl.damback.entities.auth.JwtAuthenticationResponse;
import com.avl.damback.entities.auth.LoginRequest;
import com.avl.damback.entities.auth.SignUpRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(LoginRequest request);
}
