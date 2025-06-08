package com.sconde.authentication.controller;

import com.sconde.authentication.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@Tag(name = "Authentication API", description = "Operations related to authentication")
public interface AuthController {

    @PostMapping("/register")
    @Operation(summary = "Register user")
    public ResponseEntity<?>  register(@RequestBody User user);

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<?> login(@RequestBody User user);

    @PostMapping("/logout")
    @Operation(summary = "Logout user")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token);
}
