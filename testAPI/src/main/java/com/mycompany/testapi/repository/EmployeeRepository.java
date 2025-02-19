package com.mycompany.testapi.repository;

import com.mycompany.testapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    @Query("SELECT e FROM Employee e WHERE name = :name AND password = :password")
    public Employee findByNamePassword(@Param("name") String name, @Param("password") String password);
}
