package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Role;
import org.example.data.model.User;
import org.example.data.repo.UserRepo;
import org.example.dto.request.LoginRequest;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.RegisterResponse;
import org.example.exception.UserNotFound;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServices implements UserService{
    private final UserRepo userRepo;
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setRole(Role.USER);
        var newUser =userRepo.save(user);
        RegisterResponse response= new RegisterResponse();
        response.setId(newUser.getId());
        response.setRole(String.valueOf(newUser.getRole()));
        return response;
    }

    @Override
    public RegisterResponse login(LoginRequest request) {
        var checkUser = userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
        User user = checkUser.orElseThrow(()->new UserNotFound("user not found"));
        RegisterResponse response = new RegisterResponse();
        response.setRole(String.valueOf(user.getRole()));
        response.setId(user.getId());
        return response;
    }
}
