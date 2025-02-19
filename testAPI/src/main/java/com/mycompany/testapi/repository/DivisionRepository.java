package com.mycompany.testapi.repository;

import com.mycompany.testapi.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer>{
    
}
