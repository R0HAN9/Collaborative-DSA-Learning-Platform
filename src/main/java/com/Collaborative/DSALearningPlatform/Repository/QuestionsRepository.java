package com.Collaborative.DSALearningPlatform.Repository;

import com.Collaborative.DSALearningPlatform.Models.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing database operations on the Questions collection.
 * 
 * This interface extends MongoRepository, providing CRUD operations and query methods
 * for the Questions model. It connects the application to the MongoDB database
 * and allows seamless data access.
 */
@Repository // Marks this interface as a Spring Data Repository for dependency injection
public interface QuestionsRepository extends MongoRepository<Questions, String> {

    // MongoRepository provides default CRUD methods, such as save, findById, findAll, and delete.
    // Custom query methods can be added here using method naming conventions or @Query annotations.
}
