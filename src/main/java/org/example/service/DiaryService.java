package org.example.service;

import org.example.data.model.Diary;
import org.example.dto.request.CreateDiaryRequest;
import org.example.dto.request.CreateEntryRequest;
import org.example.dto.request.UpdateEntryBodyRequest;
import org.example.dto.request.UpdateEntryTitleRequest;
import org.example.dto.response.CreateDiaryRespose;
import org.example.dto.response.CreateEntryResponse;
import org.example.dto.response.UpdateEntryResponse;

public interface DiaryService {
    Diary create(CreateDiaryRequest request);
    Diary updateTitle(long id, String title);
    CreateEntryResponse createEntry(CreateEntryRequest request);
    UpdateEntryResponse updateEntryTitle(UpdateEntryTitleRequest request);
    UpdateEntryResponse updateEntryBody(UpdateEntryBodyRequest request);

}
