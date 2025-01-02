package com.Collaborative.DSALearningPlatform.Services;

import com.Collaborative.DSALearningPlatform.Models.Questions;
import com.Collaborative.DSALearningPlatform.Repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing questions in the Collaborative DSA Learning Platform.
 * 
 * This class contains business logic for CRUD operations on the Questions model
 * and interacts with the QuestionsRepository for database access.
 */
@Service // Marks this class as a Spring service component for dependency injection
public class QuestionsService {

    @Autowired // Injects the QuestionsRepository instance automatically
    private QuestionsRepository questionsRepository;

    /**
     * Retrieves all questions from the database.
     * 
     * @return a list of all Questions.
     */
    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    /**
     * Retrieves a specific question by its ID.
     * 
     * @param id the ID of the question to retrieve.
     * @return the matching Questions object, or null if not found.
     */
    public Questions getQuestionsById(String id) {
        return questionsRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new question and saves it to the database.
     * 
     * @param questions the Questions object to save.
     * @return the saved Questions object.
     */
    public Questions createQuestions(Questions questions) {
        return questionsRepository.save(questions);
    }

    /**
     * Updates an existing question in the database.
     * 
     * @param id the ID of the question to update.
     * @param updateQuestions the updated Questions object.
     * @return the updated Questions object, or null if the question does not exist.
     */
    public Questions updateQuestions(String id, Questions updateQuestions) {
        Optional<Questions> existingQuestions = questionsRepository.findById(id);

        if (existingQuestions.isPresent()) {
            Questions questions = existingQuestions.get();

            // Update fields of the existing question
            questions.setTitle(updateQuestions.getTitle());
            questions.setDescription(updateQuestions.getDescription());

            return questionsRepository.save(questions); // Save the updated question
        }
        return null; // Return null if the question with the given ID does not exist
    }

    /**
     * Deletes a question from the database by its ID.
     * 
     * @param id the ID of the question to delete.
     */
    public void deleteQuestions(String id) {
        questionsRepository.deleteById(id);
    }
}
