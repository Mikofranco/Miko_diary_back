package org.example.service;

import org.example.dto.request.LoginRequest;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    RegisterResponse login(LoginRequest request);
}
