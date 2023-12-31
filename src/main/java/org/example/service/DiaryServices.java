package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Diary;
import org.example.data.repo.DiaryRepo;
import org.example.data.repo.EntryRepo;
import org.example.dto.request.CreateDiaryRequest;
import org.example.dto.request.CreateEntryRequest;
import org.example.dto.request.UpdateEntryBodyRequest;
import org.example.dto.request.UpdateEntryTitleRequest;
import org.example.dto.response.CreateDiaryRespose;
import org.example.dto.response.CreateEntryResponse;
import org.example.dto.response.UpdateEntryResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryServices implements DiaryService{
    private final DiaryRepo diaryRepo;
    private final EntryServices entryServices;
    private final EntryRepo entryRepo;
    @Override
    public Diary create(CreateDiaryRequest request) {
        Diary diary= new Diary();
        diary.setName(request.getName());
        diary.setDescription(request.getDescription());
        return  diaryRepo.save(diary);
    }

    @Override
    public Diary updateTitle(long id, String title) {
       var diary= diaryRepo.findById(id).orElseThrow(()->new RuntimeException("Diary not found"));
       diary.setName(title);
       return diaryRepo.save(diary);
    }

    @Override
    public CreateEntryResponse createEntry(CreateEntryRequest request) {
        Diary diary = findById(request.getDiaryId());
        var entry = entryServices.addEntry(request.getTitle(), request.getBody());
        entry.setDiary(diary);
        var savedEntry=entryRepo.save(entry);

       return CreateEntryResponse.builder()
                .body(savedEntry.getBody())
                .title(savedEntry.getTitle())
                .id(savedEntry.getId())
               .diary(savedEntry.getDiary())
                .build();
    }

    @Override
    public UpdateEntryResponse updateEntryTitle(UpdateEntryTitleRequest request) {
        Diary diary = findById(request.getDiaryId());
        diary.getEntries()
                .forEach(entry -> {
            if(entry.getId()== request.getId())
                entryServices.UpdateEntry(request.getId(), request.getTitle());
        });
        return null;
    }

    @Override
    public UpdateEntryResponse updateEntryBody(UpdateEntryBodyRequest request) {
        Diary diary= findById(request.getDiaryId());
        diary.getEntries()
                .forEach(entry -> {
            if(entry.getId()== request.getId())
                entryServices.UpdateEntryDescription(request.getId(), request.getBody());
        });
        return null;
    }

    private Diary findById(long id){
        return diaryRepo.findById(id).orElseThrow(()->new RuntimeException("Diary not found"));
    }

}
