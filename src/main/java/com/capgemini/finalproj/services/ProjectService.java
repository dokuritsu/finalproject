package com.capgemini.finalproj.services;

import java.util.List;

import com.capgemini.finalproj.entities.Project;

public interface ProjectService {
    public List<Project> getAllProjectDetails();
    public Project addProject(Project proj);                        //Create
    public Project getProjectById(int projId);                      //Read
    public Project updateProject(int projId, Project proj);         //Update
    public String deleteProject(int projId);                        //Delete
}
