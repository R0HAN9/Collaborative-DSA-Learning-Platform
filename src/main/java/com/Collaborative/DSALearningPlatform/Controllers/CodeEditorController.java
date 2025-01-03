package com.Collaborative.DSALearningPlatform.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for managing requests related to the code editor.
 * This handles the endpoint for rendering the code editor page.
 */
@Controller
public class CodeEditorController {

    /**
     * Handles GET requests to the "/editor" endpoint.
     * 
     * @return The name of the HTML view ("codeEditor") that will be rendered.
     * This maps to a corresponding template (e.g., codeEditor.html) in the templates folder.
     * 
     * Note: Ensure the "codeEditor.html" file exists in the templates directory and is correctly configured.
     * This method assumes a valid setup for Thymeleaf or any other templating engine in use.
     */
    @GetMapping("/editor")
    public String editor() {
        return "codeEditor"; // Return the view name for the code editor.
    }
}
