package com.portfolio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.model.employee.Employee;
import com.portfolio.demo.model.employee.Occupation;
import com.portfolio.demo.repository.employee.EmployeeRepository;
import com.portfolio.demo.repository.employee.OccupationRepository;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OccupationRepository occupationRepository;


    public Employee getEmployee(String username){
        Employee employee = employeeRepository.findByUsername(username);
        return employee;
    }

    public boolean saveEmployee(Employee employee){
        if (employee != null){
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }


    public boolean saveOccupation(String username, Occupation occupation){

        Employee employee = employeeRepository.findByUsername(username);

        if (employee == null){
            return false;
        }

        if (occupation == null){
            return false;
        }

        if (employee.getOccupation() != null){
            return false;
        }

        employee.setOccupation(occupation);
        occupation.setEmployee(employee);

        occupationRepository.save(occupation);
        return true;

    }

    public boolean deleteOccupation(String username){
        Employee employee = employeeRepository.findByUsername(username);
        if (employee == null){
            return false;
        }

        Occupation occupation = employee.getOccupation();
        if (occupation == null){
            return false;
        }

        occupation.setEmployee(null);
        occupationRepository.delete(occupation);
        return true;
    }

}
