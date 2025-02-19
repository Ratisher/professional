package com.mycompany.testapi.controller;

import com.mycompany.testapi.entity.Employee;
import com.mycompany.testapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin("*")
@RestController
@RequestMapping("/web")
public class WebController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/SignIn")
    public ModelAndView signIn() {
        return new ModelAndView("SignIn");
    }
    
    @GetMapping("/welcome")
    public ModelAndView welcome(@RequestParam("login") String login, @RequestParam("password") String password) {
        Employee findedEmployee = employeeRepository.findByNamePassword(login, password);
        if (findedEmployee == null) {
            return new ModelAndView("SignIn");
        }
        else {
            return new ModelAndView("Welcome");
        }
    }
}
