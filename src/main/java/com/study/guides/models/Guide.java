package com.study.guides.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String category;
    private LocalDateTime createdAt;
    private int views;

    public Guide() {
    }

    public Guide(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
}