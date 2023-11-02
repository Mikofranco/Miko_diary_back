package org.example.data.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Role {
    ADMIN("ADMIN"), USER("ADMIN");
    private final String value;

}
