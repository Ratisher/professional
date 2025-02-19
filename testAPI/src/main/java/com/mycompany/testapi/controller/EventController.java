package com.mycompany.testapi.controller;

import com.mycompany.testapi.entity.Event;
import com.mycompany.testapi.repository.EventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EventController {
    
    @Autowired
    private EventRepository eventRepository;
    
    @GetMapping("/allEvent")
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> events = eventRepository.findAll();
        if (events == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(events);
        }
    }
}
