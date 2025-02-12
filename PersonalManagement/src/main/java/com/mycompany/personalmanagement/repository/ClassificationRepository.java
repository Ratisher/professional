package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Classification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends CrudRepository<Classification, Integer>{
    
}
