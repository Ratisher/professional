package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Division;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Integer>{
    
}
