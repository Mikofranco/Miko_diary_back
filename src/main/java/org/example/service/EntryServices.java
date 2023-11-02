package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Entry;
import org.example.data.repo.EntryRepo;
import org.example.exception.EntryNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryServices implements EntryService{
    private final EntryRepo entryRepo;
    @Override
    public Entry addEntry(String title, String body) {
        Entry entry= new Entry();
        entry.setBody(body);
        entry.setTitle(title);
        return entryRepo.save(entry);
    }
    @Override
    public Entry getEntry(long id) {
        return entryRepo.findById(id)
                .orElseThrow(()-> new EntryNotFound("Entry not found"));
    }

    @Override
    public Entry UpdateEntry(long id, String title) {
        var entry =  getEntry(id);
        entry.setTitle(title);
        return entryRepo.save(entry);

    }

    @Override
    public Entry UpdateEntryDescription(long id,String body) {
        var entry =  getEntry(id);
        entry.setBody(body);
        return entryRepo.save(entry);

    }

    @Override
    public Entry UpdateEntry(long id,String title, String body) {
        var entry =  getEntry(id);
        entry.setTitle(title);
        entry.setBody(body);
        return entryRepo.save(entry);
    }

    @Override
    public List<Entry> displayAllEntry() {
        return entryRepo.findAll();
    }

    @Override
    public void deleteEntry(long id) {
         entryRepo.deleteById(id);
    }
}
