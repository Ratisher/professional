package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.EmployeeEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEventRepository extends CrudRepository<EmployeeEvent, Integer> {
    
}
