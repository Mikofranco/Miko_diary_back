package org.example.service;

import org.example.data.repo.UserRepo;
import org.example.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Test
    public void testToRegisterUser(){
        RegisterRequest request = new RegisterRequest();
        request.setPassword("12345");
        request.setEmail("paul@gmail.com");
        request.setFirstname("paul");
        request.setLastname("emeka");
        userService.register(request);
        assertThat(userRepo.count(), is(1L));
    }

}