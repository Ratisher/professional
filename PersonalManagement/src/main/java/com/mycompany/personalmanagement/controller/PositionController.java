package com.mycompany.personalmanagement.controller;

import com.mycompany.personalmanagement.entity.Position;
import com.mycompany.personalmanagement.repository.PositionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/position")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/getPosition/{positionId}")
    public ResponseEntity<Position> getPositionById(@PathVariable("positionId") int positionId) {
        Position findedPosition = positionRepository.findById(positionId).get();
        if (findedPosition == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(findedPosition);
        }
    }

    @GetMapping("/allPosition")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positions = (List<Position>) positionRepository.findAll();
        if (positions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(positions);
        }
    }

}
