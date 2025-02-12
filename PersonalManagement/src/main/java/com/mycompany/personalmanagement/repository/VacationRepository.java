package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Vacation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends CrudRepository<Vacation, Integer>{
    
}
