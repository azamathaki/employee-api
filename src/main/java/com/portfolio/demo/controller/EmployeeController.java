package com.portfolio.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.demo.model.employee.Employee;
import com.portfolio.demo.model.employee.Occupation;
import com.portfolio.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{username}")
    public Employee gettingEmployee(@PathVariable("username") String username){
        return employeeService.getEmployee(username);
    }

    @PostMapping("/employees")
    public boolean creatingEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{username}/create/occupation")
    public boolean creatingOccupation(@PathVariable("username") String username, 
                                    @RequestBody Occupation occupation)
    {
        return employeeService.saveOccupation(username, occupation);
    }

    @DeleteMapping("/employees/{username}/delete/occupation")
    public boolean deletingOccupation(@PathVariable("username") String username){
        return employeeService.deleteOccupation(username);
    }



}
