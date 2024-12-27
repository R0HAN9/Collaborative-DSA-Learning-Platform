package com.Collaborative.DSALearningPlatform.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodeEditorController {

    @GetMapping("/editor")
    public String editor() {
        return "codeEditor";
    }
}
