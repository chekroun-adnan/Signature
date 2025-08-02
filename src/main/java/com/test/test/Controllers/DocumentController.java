package com.test.test.Controllers;

import com.test.test.Services.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(
            @RequestParam("title") String title,
            @RequestParam("file") MultipartFile file) {

        try {
            String result = documentService.uploadDocument(title, file);

            switch (result) {
                case "CREATED":
                    return ResponseEntity.status(HttpStatus.CREATED).body("Document uploaded successfully.");
                case "Exist":
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Document already exists.");
                default:
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload document.");
            }

        } catch (Exception e) {
            System.err.println("Error uploading document: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error occurred.");
        }
    }
}

