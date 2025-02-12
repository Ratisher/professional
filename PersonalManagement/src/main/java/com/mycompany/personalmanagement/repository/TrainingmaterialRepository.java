package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Trainingmaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingmaterialRepository extends CrudRepository<Trainingmaterial, Integer>{
    
}
