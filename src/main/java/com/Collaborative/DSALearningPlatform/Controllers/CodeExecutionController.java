package com.Collaborative.DSALearningPlatform.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/run")
public class CodeExecutionController {

    // Run code based on language
    @PostMapping
    public ResponseEntity<?> runCode(@RequestBody CodeRequest codeRequest) {
        String output = "";
        try {
            switch (codeRequest.getLanguage()) {
                case "java":
                    output = runJavaCode(codeRequest.getCode());
                    break;
                case "python":
                    output = runPythonCode(codeRequest.getCode());
                    break;
                case "javascript":
                    output = runJavaScriptCode(codeRequest.getCode());
                    break;
                case "c":
                    output = runCCode(codeRequest.getCode());
                    break;
                default:
                    return ResponseEntity.badRequest().body("Unsupported language");
            }
            return ResponseEntity.ok(new CodeResponse(output));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error executing code: " + e.getMessage());
        }
    }

    private String runJavaCode(String code) throws Exception {
        String fileName = "TempCode.java";
        executeCommand("echo \"" + code + "\" > " + fileName);
        executeCommand("javac " + fileName);
        return executeCommand("java TempCode");
    }

    private String runPythonCode(String code) throws Exception {
        String fileName = "TempCode.py";
        executeCommand("echo \"" + code + "\" > " + fileName);
        return executeCommand("python " + fileName);
    }

    private String runJavaScriptCode(String code) throws Exception {
        String fileName = "TempCode.js";
        executeCommand("echo \"" + code + "\" > " + fileName);
        return executeCommand("node " + fileName);
    }

    private String runCCode(String code) throws Exception {
        String fileName = "TempCode.c";
        executeCommand("echo \"" + code + "\" > " + fileName);
        executeCommand("gcc " + fileName + " -o TempCode");
        return executeCommand("./TempCode");
    }

    private String executeCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        process.waitFor();
        return output.toString();
    }

    static class CodeRequest {
        private String code;
        private String language;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }

    static class CodeResponse {
        private String output;

        public CodeResponse(String output) {
            this.output = output;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }
    }
}
