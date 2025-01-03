package com.Collaborative.DSALearningPlatform.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Controller for executing user-submitted code.
 * Supports multiple programming languages and handles code execution dynamically.
 */
@RestController
@RequestMapping("/run")
public class CodeExecutionController {

    /**
     * Endpoint to execute user-submitted code.
     * 
     * @param codeRequest Contains the code and language to execute.
     * @return ResponseEntity with execution output or error message.
     */
    @PostMapping
    public ResponseEntity<?> runCode(@RequestBody CodeRequest codeRequest) {
        String output = "";
        try {
            // Select execution logic based on the programming language
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
            // Handle unexpected errors gracefully
            return ResponseEntity.status(500).body("Error executing code: " + e.getMessage());
        }
    }

    /**
     * Executes Java code.
     * 
     * @param code The Java code to execute.
     * @return Output of the code execution.
     * @throws Exception If an error occurs during execution.
     */
    private String runJavaCode(String code) throws Exception {
        String fileName = "TempCode.java";
        executeCommand("echo \"" + code + "\" > " + fileName");
        executeCommand("javac " + fileName); // Compile the Java file
        return executeCommand("java TempCode"); // Run the compiled code
    }

    /**
     * Executes Python code.
     * 
     * @param code The Python code to execute.
     * @return Output of the code execution.
     * @throws Exception If an error occurs during execution.
     */
    private String runPythonCode(String code) throws Exception {
        String fileName = "TempCode.py";
        executeCommand("echo \"" + code + "\" > " + fileName");
        return executeCommand("python " + fileName); // Run Python code
    }

    /**
     * Executes JavaScript code.
     * 
     * @param code The JavaScript code to execute.
     * @return Output of the code execution.
     * @throws Exception If an error occurs during execution.
     */
    private String runJavaScriptCode(String code) throws Exception {
        String fileName = "TempCode.js";
        executeCommand("echo \"" + code + "\" > " + fileName");
        return executeCommand("node " + fileName); // Run JavaScript code
    }

    /**
     * Executes C code.
     * 
     * @param code The C code to execute.
     * @return Output of the code execution.
     * @throws Exception If an error occurs during execution.
     */
    private String runCCode(String code) throws Exception {
        String fileName = "TempCode.c";
        executeCommand("echo \"" + code + "\" > " + fileName");
        executeCommand("gcc " + fileName + " -o TempCode"); // Compile the C code
        return executeCommand("./TempCode"); // Run the compiled binary
    }

    /**
     * Executes a shell command.
     * 
     * @param command The shell command to execute.
     * @return Output of the executed command.
     * @throws Exception If an error occurs during command execution.
     */
    private String executeCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        process.waitFor(); // Wait for the process to complete
        return output.toString();
    }

    /**
     * DTO for code execution requests.
     */
    static class CodeRequest {
        private String code; // User-submitted code
        private String language; // Programming language

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

    /**
     * DTO for code execution responses.
     */
    static class CodeResponse {
        private String output; // Output of the executed code

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
