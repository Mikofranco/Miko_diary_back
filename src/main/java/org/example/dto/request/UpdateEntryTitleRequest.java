package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.example.data.model.Diary;
@Getter
@Setter
public class UpdateEntryTitleRequest {
    private long id;
    private String title;
    private String body;
    private long diaryId;
}
