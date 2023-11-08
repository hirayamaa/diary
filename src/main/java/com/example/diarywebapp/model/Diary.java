package com.example.diarywebapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bodytext", nullable = false)
    private String bodyText;
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime createDateTime;
}
