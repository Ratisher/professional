package com.mycompany.personalmanagement.controller;

import com.mycompany.personalmanagement.entity.Employee;
import com.mycompany.personalmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/web")
public class WebController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/formAuthorization")
    public ModelAndView login() {
        return new ModelAndView("AuthorizationForm");
    }
        
    @GetMapping("/signIn")
    public ModelAndView signIn(@RequestParam("login") String login, @RequestParam("password") String password){
        Employee employee = employeeRepository.findByLoginPassword(login, password);
        if (employee != null) {
            ModelAndView successModel = new ModelAndView("welcome");
            System.out.println(employee);
            successModel.addObject("employee", employee);
            successModel.addObject("message", "Привет");
            return successModel;
        }
        else {
            return new ModelAndView("login");
        }
    }
}
