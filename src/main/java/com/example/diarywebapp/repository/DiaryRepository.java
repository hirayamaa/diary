package com.example.diarywebapp.repository;

import com.example.diarywebapp.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {

}
