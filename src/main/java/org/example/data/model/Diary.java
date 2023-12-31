package org.example.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter@Getter
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isUnlocked;
    private String name;
    private String description;
    @OneToOne
    private User user;
    @OneToMany
    Set<Entry> entries;
}
