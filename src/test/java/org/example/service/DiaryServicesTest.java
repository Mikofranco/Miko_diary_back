package org.example.service;

import org.example.data.repo.DiaryRepo;
import org.example.dto.request.CreateDiaryRequest;
import org.example.dto.request.CreateEntryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DiaryServicesTest {
    @Autowired
    private DiaryService diaryService;
    @Autowired
    private DiaryRepo repo;
    @Test
    public void testToCreateDiary(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setDescription("Story");
        request.setName("a");
        diaryService.create(request);
        assertEquals(repo.count(),1);
    }
    @Test
    public void testToCreateMultipleDiary(){
        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setDescription("second story");
        request.setName("b");
        diaryService.create(request);
        CreateDiaryRequest request1 = new CreateDiaryRequest();
        request1.setDescription("third story");
        request1.setName("c");
        diaryService.create(request1);
        CreateDiaryRequest request2 = new CreateDiaryRequest();
        request2.setDescription("fourth story");
        request2.setName("d");
        diaryService.create(request2);
        assertEquals(repo.count(),4);
    }
    @Test
    public void testToUpdateTitle(){
        var diary =diaryService.updateTitle(2,"updated");
        assertThat(diary.getName(),is("updated"));
    }
    @Test
    public void testToCreateEntry(){
        CreateEntryRequest request= new CreateEntryRequest();
        request.setDiaryId(1L);
        request.setTitle("new Diary");
        request.setBody("i just added this entry in the diary test class");
        diaryService.createEntry(request);
        assertEquals(repo.count(),4);
    }
    @Test
    public void testToUpdateEntry(){

    }


}