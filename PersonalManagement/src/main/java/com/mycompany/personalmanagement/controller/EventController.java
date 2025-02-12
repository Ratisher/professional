package com.mycompany.personalmanagement.controller;

import com.mycompany.personalmanagement.entity.Event;
import com.mycompany.personalmanagement.repository.EventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    
    @Autowired
    private EventRepository eventRepository;
    
    @GetMapping("/allEvent")
    public ResponseEntity<List<Event>> getAllEvent() {
        List<Event> events = (List<Event>) eventRepository.findAll();
        if (events == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(events);
        }
    }
}
