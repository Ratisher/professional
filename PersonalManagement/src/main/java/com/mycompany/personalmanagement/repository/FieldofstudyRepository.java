package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Fieldofstudy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldofstudyRepository extends CrudRepository<Fieldofstudy, Integer>{
    
}
