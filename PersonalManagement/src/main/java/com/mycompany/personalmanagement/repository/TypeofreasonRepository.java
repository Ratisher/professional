package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Typeofreason;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofreasonRepository extends CrudRepository<Typeofreason, Integer>{
    
}
