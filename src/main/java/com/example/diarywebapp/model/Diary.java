package com.example.diarywebapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Diary {
    public Diary(String bodyText, LocalDateTime createDateTime) {
        this.bodyText = bodyText;
        this.createDateTime = createDateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bodytext", nullable = false)
    @NotBlank
    @Size(min=5, max=200)
    private String bodyText;
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime createDateTime;
}
