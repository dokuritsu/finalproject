package com.capgemini.finalproj.repository;

import com.capgemini.finalproj.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    
}
