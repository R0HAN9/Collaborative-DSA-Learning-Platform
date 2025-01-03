package com.Collaborative.DSALearningPlatform.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a question entity stored in the MongoDB collection "questions".
 * This model is used to manage and persist question data for the Collaborative DSA Learning Platform.
 */
@Document(collection = "questions")
public class Questions {

    // Unique identifier for each question
    @Id
    private String id;

    // Title of the question
    private String title;

    // Detailed description of the question
    private String description;

    /**
     * Retrieves the unique identifier of the question.
     *
     * @return the question ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the question.
     *
     * @param id the question ID to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the title of the question.
     *
     * @return the question title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title for the question.
     *
     * @param title the question title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the description of the question.
     *
     * @return the question description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the question.
     *
     * @param description the question description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
