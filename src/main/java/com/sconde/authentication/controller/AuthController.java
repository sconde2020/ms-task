package com.sconde.authentication.controller;

import com.sconde.authentication.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;

@RequestMapping("/api/auth")
@Tag(name = "Authentication API", description = "Operations related to user authentication")
public interface AuthController {

    @PostMapping("/register")
    @Operation(summary = "Register user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = User.class),
                            examples = @ExampleObject(
                                    name = "New user registration",
                                    value = """
                                            {
                                              "username": "johndoe",
                                              "password": "strongPassword123"
                                            }
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "User registered successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input or user already exists")
            })
    ResponseEntity<?> register(@RequestBody User user);

    @PostMapping("/login")
    @Operation(summary = "Login user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = User.class),
                            examples = @ExampleObject(
                                    name = "Login user",
                                    value = """
                                            {
                                              "username": "johndoe",
                                              "password": "strongPassword123"
                                            }
                                            """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successful, token returned"),
                    @ApiResponse(responseCode = "401", description = "Invalid credentials"),
                    @ApiResponse(responseCode = "400", description = "Bad request (e.g. missing fields)")
            })
    ResponseEntity<?> login(@RequestBody User user);

    @PostMapping("/logout")
    @Operation(summary = "Logout user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Logout successful"),
                    @ApiResponse(responseCode = "401", description = "Invalid or missing token")
            })
    ResponseEntity<?> logout(
            @Parameter(
                    name = "Authorization",
                    description = "Bearer token",
                    required = true,
                    example = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
            )
            @RequestHeader("Authorization") String token
    );
}
