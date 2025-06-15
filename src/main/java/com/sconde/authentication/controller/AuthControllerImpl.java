package com.sconde.authentication.controller;

import com.sconde.authentication.model.User;
import com.sconde.authentication.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<?> register(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(user));
    }

    @Override
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(authService.login(user));
    }

    @Override
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(authService.logout(token));
    }
}


