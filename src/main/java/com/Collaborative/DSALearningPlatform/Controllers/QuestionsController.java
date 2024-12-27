package com.Collaborative.DSALearningPlatform.Controllers;

import com.Collaborative.DSALearningPlatform.Models.Questions;
import com.Collaborative.DSALearningPlatform.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping
    public List<Questions> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Questions getQuestionsById(@PathVariable String id) {
        return questionsService.getQuestionsById(id);
    }

    @PostMapping
    public Questions createQuestions(@RequestBody Questions questions) {
        return questionsService.createQuestions(questions);
    }

    @PutMapping("/{id}")
    public Questions updateQuestions(@PathVariable String id, @RequestBody Questions updateQuestions) {
        return questionsService.updateQuestions(id, updateQuestions);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestions(@PathVariable String id) {
        questionsService.deleteQuestions(id);
        return "Problem with ID " + id + " deleted Successfully!";
    }
}
