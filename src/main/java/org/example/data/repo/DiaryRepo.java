package org.example.data.repo;

import org.example.data.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepo extends JpaRepository<Diary, Long> {
}
