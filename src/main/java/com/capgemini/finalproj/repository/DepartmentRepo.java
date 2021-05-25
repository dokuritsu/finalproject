package com.capgemini.finalproj.repository;

import com.capgemini.finalproj.entities.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
    
}
