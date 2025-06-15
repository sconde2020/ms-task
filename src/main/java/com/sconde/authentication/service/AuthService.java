package com.sconde.authentication.service;

import com.sconde.authentication.model.User;

import java.util.Map;

public interface AuthService {
    Map<String, Object> register(User user);
    Map<String, Object> login(User user);
    Map<String, Object> logout(String token);
}

