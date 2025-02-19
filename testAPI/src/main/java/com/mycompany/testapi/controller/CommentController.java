package com.mycompany.testapi.controller;

import com.mycompany.testapi.entity.Comment;
import com.mycompany.testapi.entity.Document;
import com.mycompany.testapi.entity.Employee;
import com.mycompany.testapi.repository.CommentRepository;
import com.mycompany.testapi.repository.DocumentRepository;
import com.mycompany.testapi.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
   
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired 
    private DocumentRepository documentRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/Document/{documentId}/Comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable("documentId") String documentId) {
        List<Comment> comments = commentRepository.findByDocumentId(documentId);
        if (comments == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(comments);
        }
    }
    
    @PostMapping("/Document/{documentId}/Comment")
    public ResponseEntity<Comment> postComment(@PathVariable("documentId") String documentId, @RequestParam("text") String text, @RequestParam("employeeId") String employeeId) {
        Comment newComment = new Comment();
        Employee findedEmployee = employeeRepository.findById(Integer.parseInt(employeeId)).get();
        Document findedDocument = documentRepository.findById(Integer.parseInt(documentId)).get();
        newComment.setText(text);
        newComment.setDocumentid(findedDocument);
        newComment.setEmployeeId(findedEmployee);
        Comment addedComment = commentRepository.save(newComment);
        if (addedComment != null) {
            return ResponseEntity.ok(addedComment);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
