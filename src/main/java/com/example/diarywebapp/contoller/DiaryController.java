package com.example.diarywebapp.contoller;

import com.example.diarywebapp.model.Diary;
import com.example.diarywebapp.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("diary")
public class DiaryController {
    private final DiaryRepository diaryRepository;

    // 日記一覧情報の取得
    @GetMapping("summary")
    public String summary(Model model) {
       List<Diary> diaryList =  diaryRepository.findAll();
       model.addAttribute("diaries", diaryList);
       return "summary";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer id) {
        diaryRepository.deleteById(id);
        return "redirect:/diary/summary";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("diary", new Diary());
        return "edit";
    }

    @GetMapping("/edit/{id}")
    public String editDiary(@PathVariable Integer id, Model model) {
        model.addAttribute("diary", diaryRepository.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute Diary diary, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        diary.setCreateDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        diaryRepository.save(diary);
        return "redirect:/diary/summary";
    }
}
