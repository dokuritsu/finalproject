package com.capgemini.finalproj.controllers;

import java.util.List;

import com.capgemini.finalproj.entities.Project;
import com.capgemini.finalproj.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    
    @Autowired
    ProjectService projService;

    @GetMapping("/projects")
    public List<Project> getAllProjDetails(){
        return projService.getAllProjectDetails();
    }

    @PostMapping("/project")
    public ResponseEntity<Project> saveProject(@RequestBody Project proj){
        return ResponseEntity.ok(projService.addProject(proj));
    }

    @GetMapping("/project/{projId}")
    public ResponseEntity<Project> getProjById(@PathVariable int projId){
        return ResponseEntity.ok(projService.getProjectById(projId));
    }

    @PutMapping("/project/{projId}")
    public ResponseEntity<Project> updateProject(@PathVariable int projId, @RequestBody Project proj){
        return ResponseEntity.ok(projService.updateProject(projId, proj));
    }

    @DeleteMapping("/project/{projId}")
    public ResponseEntity<String> deleteProject(@PathVariable int projId){
        return ResponseEntity.ok(projService.deleteProject(projId));
    }
}
