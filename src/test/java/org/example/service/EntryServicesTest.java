package org.example.service;

import org.example.data.repo.EntryRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EntryServicesTest {
    @Autowired
    private EntryService entryService;
    @Autowired
    private EntryRepo entryRepo;
    @Test
    public void testToAddEntry(){
        entryService.addEntry("new Diary","let this work");
        assertEquals(entryRepo.count(),1);
    }
    @Test
    public void testToAddMultipleEntry(){
        entryService.addEntry("new day","let this work");
        entryService.addEntry("new month","let this work");
        entryService.addEntry("new week","let this work");
        entryService.addEntry("new year","let this work");
        assertEquals(entryRepo.count(),5);
    }
    @Test
    public void testToUpdateEntry(){
        var entry= entryService.UpdateEntryDescription(1,"i just updated entry one");
        assertThat(entry.getBody(),is("i just updated entry one"));
    }
    @Test
    public void deleteEntry(){
        entryService.deleteEntry(4);
        assertEquals(entryRepo.count(),4);
    }
}