package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Statusofstudy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusofstudyRepository extends CrudRepository<Statusofstudy, Integer>{
    
}
