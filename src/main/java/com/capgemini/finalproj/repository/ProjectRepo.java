package com.capgemini.finalproj.repository;

import java.util.List;

import com.capgemini.finalproj.entities.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepo extends JpaRepository<Project, Integer>{

    
    // List<Project> findProjByEmpId(int empId);
}
