package com.Collaborative.DSALearningPlatform.Controllers;

import com.Collaborative.DSALearningPlatform.Models.Questions;
import com.Collaborative.DSALearningPlatform.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing questions.
 * Provides endpoints for CRUD operations on questions.
 */
@RestController
@RequestMapping("/questions")
public class QuestionsController {

    // Service layer dependency for handling business logic
    @Autowired
    private QuestionsService questionsService;

    /**
     * Retrieve all questions from the database.
     *
     * @return List of all questions.
     */
    @GetMapping
    public List<Questions> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    /**
     * Retrieve a specific question by its ID.
     *
     * @param id Unique identifier of the question.
     * @return The question object if found.
     */
    @GetMapping("/{id}")
    public Questions getQuestionsById(@PathVariable String id) {
        return questionsService.getQuestionsById(id);
    }

    /**
     * Create a new question in the database.
     *
     * @param questions The question object to be created.
     * @return The created question object with its generated ID.
     */
    @PostMapping
    public Questions createQuestions(@RequestBody Questions questions) {
        return questionsService.createQuestions(questions);
    }

    /**
     * Update an existing question by its ID.
     *
     * @param id             Unique identifier of the question to update.
     * @param updateQuestions The updated question object.
     * @return The updated question object.
     */
    @PutMapping("/{id}")
    public Questions updateQuestions(@PathVariable String id, @RequestBody Questions updateQuestions) {
        return questionsService.updateQuestions(id, updateQuestions);
    }

    /**
     * Delete a specific question by its ID.
     *
     * @param id Unique identifier of the question to delete.
     * @return Success message indicating the question has been deleted.
     */
    @DeleteMapping("/{id}")
    public String deleteQuestions(@PathVariable String id) {
        questionsService.deleteQuestions(id);
        return "Problem with ID " + id + " deleted successfully!";
    }
}
