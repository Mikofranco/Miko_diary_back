package org.example.dto.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Setter;
import org.example.data.model.Role;

@Setter
@Data
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String password;
    private String email;
}
