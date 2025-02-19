package com.mycompany.testapi.controller;

import com.mycompany.testapi.entity.Position;
import com.mycompany.testapi.repository.PositionRepository;
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
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;
    
    @GetMapping("/positionById/{positionId}")
    public ResponseEntity<Position> getPositionById(@PathVariable("positionId") String positionId) {
        Position findedPosition = positionRepository.findById(Integer.parseInt(positionId)).get();
        if (findedPosition == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(findedPosition);
        }
    }
    
    @GetMapping("/allPosition")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positions = positionRepository.findAll();
        if (positions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(positions);
        }
    }
}
