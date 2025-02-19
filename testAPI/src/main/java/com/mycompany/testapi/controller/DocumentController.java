package com.mycompany.testapi.controller;

import com.mycompany.testapi.entity.Document;
import com.mycompany.testapi.repository.DocumentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;
    
    @GetMapping("/Documents")
    public ResponseEntity<List<Document>> getDocument() {
        List<Document> documents = documentRepository.findAll();
        if (documents == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(documents);
        }
    }
}
