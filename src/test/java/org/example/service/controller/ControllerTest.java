package org.example.service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.request.LoginRequest;
import org.example.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void register() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        RegisterRequest request = new RegisterRequest();
        request.setLastname("chinedu");
        request.setFirstname("chinwe");
        request.setEmail("chinwe@gmail.com");
        request.setPassword("12345");
        byte[] json =mapper.writeValueAsBytes(request);
        mockMvc.perform(post("/api/v1/user/register")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
    @Test
    public void loginTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        LoginRequest request = new LoginRequest();
        request.setEmail("chinwe@gmail.com");
        request.setPassword("12345");

        byte[] json = mapper.writeValueAsBytes(request);
        mockMvc.perform(post("/api/v1/user/login")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}
