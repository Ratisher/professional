package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Typeofevent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeofeventRepository extends CrudRepository<Typeofevent, Integer>{
    
}
