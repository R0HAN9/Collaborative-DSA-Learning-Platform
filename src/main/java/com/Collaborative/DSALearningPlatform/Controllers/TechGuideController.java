package com.Collaborative.DSALearningPlatform.Controllers;

import com.Collaborative.DSALearningPlatform.Models.TechGuideLink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for providing technology guide links.
 * This controller serves endpoints to fetch curated links for learning and interview preparation.
 */
@RestController
public class TechGuideController {

    /**
     * Endpoint to fetch a list of curated technology guide links.
     *
     * @return A list of {@link TechGuideLink} objects containing the title and URL of each guide.
     */
    @GetMapping("/techGuide")
    public List<TechGuideLink> getTechGuideLinks() {
        // Initialize a list to store tech guide links
        List<TechGuideLink> links = new ArrayList<>();

        // Add curated links to the list
        links.add(new TechGuideLink("Google Tech Dev Guide", "https://techdevguide.withgoogle.com/"));
        links.add(new TechGuideLink("DSA Problems in Java", "https://techdevguide.withgoogle.com/paths/data-structures-and-algorithms/?programming_languages=java"));
        links.add(new TechGuideLink("Interview Preparation", "https://techdevguide.withgoogle.com/paths/interview/?programming_languages=java"));

        // Return the list of links
        return links;
    }
}
