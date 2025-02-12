package com.mycompany.personalmanagement.controller;

import com.mycompany.personalmanagement.entity.Employee;
import com.mycompany.personalmanagement.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        if (employees == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return ResponseEntity.ok(employees);
        }
    }
    
    @GetMapping("/employeeByDivision")
    public ResponseEntity<List<Employee>> getEmployeeByDivision(@RequestParam("division") String division) {
        List<Employee> employees = (List<Employee>) employeeRepository.findByDivision(division);
        if (employees == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return ResponseEntity.ok(employees);
        }
    }
    
    @GetMapping("/authorization")
    public ResponseEntity<Employee> getAuthorization(@RequestParam("login") String login, @RequestParam("password") String password) {
        Employee employee = employeeRepository.findByLoginPassword(login, password);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(employee);
        }
    }
    
    @GetMapping("/getById/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") String employeeId) {
        Employee findedEmployee = employeeRepository.findById(Integer.parseInt(employeeId)).get();
        if (findedEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(findedEmployee);
        }
    }
}
