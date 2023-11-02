package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class RegisterResponse {
    private Long id;
    private final String message="SUCCESSFUL";
    private String role;
}
