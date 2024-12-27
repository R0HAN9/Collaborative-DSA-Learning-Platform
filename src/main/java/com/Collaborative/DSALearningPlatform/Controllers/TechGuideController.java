package com.Collaborative.DSALearningPlatform.Controllers;

import com.Collaborative.DSALearningPlatform.Models.TechGuideLink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TechGuideController {

    @GetMapping("/techGuide")
    public List<TechGuideLink> getTechGuideLinks() {
        // Return a list of links
        List<TechGuideLink> links = new ArrayList<>();
        links.add(new TechGuideLink("Google Tech Dev Guide", "https://techdevguide.withgoogle.com/"));
        links.add(new TechGuideLink("DSA Problems in Java", "https://techdevguide.withgoogle.com/paths/data-structures-and-algorithms/?programming_languages=java"));
        links.add(new TechGuideLink("Interview Preparation", "https://techdevguide.withgoogle.com/paths/interview/?programming_languages=java"));
        return links;
    }
}
