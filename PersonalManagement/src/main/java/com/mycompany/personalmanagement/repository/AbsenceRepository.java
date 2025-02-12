
package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Absence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends CrudRepository<Absence, Integer>{
    
}
