package com.portfolio.demo.model.employee;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "occupations")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Occupation {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String occupationName;
    private String description;
    private String excperience;
    private String location;
    private String salary;


    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Occupation(String occupationName, String description, String excperience, String location, String salary) {
        this.occupationName = occupationName;
        this.description = description;
        this.excperience = excperience;
        this.location = location;
        this.salary = salary;
    }


    public Occupation() {
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getOccupationName() {
        return occupationName;
    }


    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getExcperience() {
        return excperience;
    }


    public void setExcperience(String excperience) {
        this.excperience = excperience;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public String getSalary() {
        return salary;
    }


    public void setSalary(String salary) {
        this.salary = salary;
    }


    public Employee getEmployee() {
        return employee;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
}
