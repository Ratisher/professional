package com.mycompany.testapi.controller;

import com.mycompany.testapi.entity.Employee;
import com.mycompany.testapi.repository.EmployeeRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @PostMapping("/SignIn")
    public ResponseEntity signIn(@RequestParam("name") String name, @RequestParam("password") String password) {
        Employee findedEmployee = employeeRepository.findByNamePassword(name, password);
        if (findedEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            Map<String, Object> responseData = new HashMap<>();
            
            responseData.put("password", password);
            responseData.put("name", name);
            
            return ResponseEntity.ok(responseData);
        }
    }
    
    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(employees);
        }
    }
    
    @GetMapping("/employeeById/{employeeId}")
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
