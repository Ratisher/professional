package com.mycompany.personalmanagement.repository;

import com.mycompany.personalmanagement.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT empl FROM Employee empl WHERE login = :login AND password = :password")
    Employee findByLoginPassword(@Param("login") String login, @Param("password") String password);

    @Query("SELECT empl FROM Employee empl WHERE divisionDivisionID.name = :division")
    List<Employee> findByDivision(@Param("division") String division);
}
