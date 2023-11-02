package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class CreateDiaryRequest {
    private String name;
    private String description;
}
