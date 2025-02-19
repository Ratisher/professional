package com.mycompany.testapi.controller;

import com.mycompany.testapi.entity.Division;
import com.mycompany.testapi.repository.DivisionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DivisionController {
    
    @Autowired
    private DivisionRepository divisionRepository;
    
    @GetMapping("/allDivision")
    public ResponseEntity<List<Division>> getDivisions() {
        List<Division> divisions = (List<Division>) divisionRepository.findAll();
        if (divisions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(divisions);
        }
    }
    
    @GetMapping("/divisionById/{divisionId}")
    public ResponseEntity<Division> getDivisionById(@PathVariable("divisionId") String divisionId) {
        Division findedDivision = divisionRepository.findById(Integer.parseInt(divisionId)).get();
        if (findedDivision == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(findedDivision);
        }
    }
}
