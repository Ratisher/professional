package com.mycompany.testapi.repository;

import com.mycompany.testapi.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{
    
}
