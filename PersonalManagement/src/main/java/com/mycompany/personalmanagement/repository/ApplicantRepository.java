package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Integer>{
    
}
