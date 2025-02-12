package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer>{
    
}
