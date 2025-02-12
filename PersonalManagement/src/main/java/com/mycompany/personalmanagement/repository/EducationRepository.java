package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository<Education, Integer>{
    
}
