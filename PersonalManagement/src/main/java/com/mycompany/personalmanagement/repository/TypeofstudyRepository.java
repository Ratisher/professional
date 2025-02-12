package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Typeofstudy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofstudyRepository extends CrudRepository<Typeofstudy, Integer>{
    
}
