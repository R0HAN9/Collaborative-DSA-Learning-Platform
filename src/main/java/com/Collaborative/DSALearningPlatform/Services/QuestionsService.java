package com.Collaborative.DSALearningPlatform.Services;

import com.Collaborative.DSALearningPlatform.Models.Questions;
import com.Collaborative.DSALearningPlatform.Repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    public Questions getQuestionsById(String id) {
        return questionsRepository.findById(id).orElse(null);
    }

    public Questions createQuestions(Questions questions) {
        return questionsRepository.save(questions);
    }

    public Questions updateQuestions(String id, Questions updateQuestions) {
        Optional<Questions> existingQuestions = questionsRepository.findById(id);

        if (existingQuestions.isPresent()) {
            Questions questions = existingQuestions.get();

            questions.setTitle(updateQuestions.getTitle());
            questions.setDescription(updateQuestions.getDescription());

            return questionsRepository.save(questions);
        }
        return null;
    }

    public void deleteQuestions(String id) {
        questionsRepository.deleteById(id);
    }
}
