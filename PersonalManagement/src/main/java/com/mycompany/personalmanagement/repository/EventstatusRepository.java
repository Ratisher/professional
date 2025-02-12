package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Eventstatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventstatusRepository extends CrudRepository<Eventstatus, Integer>{
    
}
