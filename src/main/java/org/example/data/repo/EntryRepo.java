package org.example.data.repo;

import org.example.data.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepo extends JpaRepository<Entry, Long> {
}
