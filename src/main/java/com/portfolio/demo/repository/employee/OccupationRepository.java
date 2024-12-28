package com.portfolio.demo.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.demo.model.employee.Occupation;

public interface OccupationRepository extends JpaRepository<Occupation, Long>{
    
}
