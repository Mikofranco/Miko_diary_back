package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UpdateDiaryRequest {
    private long id;
    private String name;
}
