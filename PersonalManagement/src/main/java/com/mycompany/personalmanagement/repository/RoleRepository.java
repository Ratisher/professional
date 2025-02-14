package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
    
}
