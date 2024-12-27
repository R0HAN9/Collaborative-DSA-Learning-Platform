package com.Collaborative.DSALearningPlatform.Repository;

import com.Collaborative.DSALearningPlatform.Models.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends MongoRepository<Questions, String> {

}
