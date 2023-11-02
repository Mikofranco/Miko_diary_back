package org.example.service;

import org.example.data.model.Entry;

import java.util.List;

public interface EntryService {
    Entry addEntry(String title, String body);
    Entry getEntry(long id);
    Entry UpdateEntry(long id,String title);
    Entry UpdateEntryDescription(long id,String body);
    Entry UpdateEntry(long id,String title, String body);
    List<Entry> displayAllEntry();
    void deleteEntry(long id);
}
