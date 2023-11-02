package org.example.dto.response;

import lombok.*;
import org.example.data.model.Diary;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class CreateEntryResponse {
    private long id;
    private String title;
    private String body;
    private Diary diary;
}
