package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UpdateDiaryResponse {
    private long id;
    private final String message="SUCCESSFUL";
}
