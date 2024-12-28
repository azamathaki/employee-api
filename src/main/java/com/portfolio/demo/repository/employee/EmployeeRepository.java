package com.portfolio.demo.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.demo.model.employee.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    Employee findByUsername(String username);

}
