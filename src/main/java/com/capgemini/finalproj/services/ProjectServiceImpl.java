package com.capgemini.finalproj.services;

import java.util.List;

import com.capgemini.finalproj.entities.Employee;
import com.capgemini.finalproj.entities.Project;
import com.capgemini.finalproj.exceptions.ExistingProjectException;
import com.capgemini.finalproj.exceptions.ProjectNotFoundException;
import com.capgemini.finalproj.repository.ProjectRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepo projectRepo;

    @Override
    public List<Project> getAllProjectDetails() {
        return projectRepo.findAll();
    }

    @Override
    public Project addProject(Project proj) {
        if(projectRepo.findById(proj.getProjId()).isPresent()){
            throw new ExistingProjectException("This project already exists...");
        }
        return projectRepo.save(proj);
    }

    @Override
    public Project getProjectById(int projId) {
       return projectRepo.findById(projId).orElseThrow(() -> new ProjectNotFoundException("Unable to find project with given id..."));
    }

    @Override
    public Project updateProject(int projId, Project proj) {
        if(projectRepo.findById(projId).isPresent()){
            return projectRepo.save(proj);
        } else {
            throw new ProjectNotFoundException("Unable to find project with given id...");
        }
    }

    @Override
    public String deleteProject(int projId) {
        if(projectRepo.findById(projId).isPresent()){
            Project p = projectRepo.findById(projId).get();
            if((p.getEmployees()!=null) && (!p.getEmployees().isEmpty())){
                for(Employee e : p.getEmployees()){
                    e.setProj(null);
                }
            }
            projectRepo.deleteById(projId);
            return "Project successfully deleted...";
        } else {
            throw new ProjectNotFoundException("Unable to delete project with given id...");
        }
    }


    
}
