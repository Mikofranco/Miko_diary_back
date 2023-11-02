package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class CreateEntryRequest {
    private long diaryId;
    private String title;
    private String body;
}
