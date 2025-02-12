package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer>{
    
}
