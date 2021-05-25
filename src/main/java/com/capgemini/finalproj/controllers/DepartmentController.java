package com.capgemini.finalproj.controllers;

import java.util.List;

import com.capgemini.finalproj.entities.Department;
import com.capgemini.finalproj.services.DepartmentService;

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
public class DepartmentController {
    
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDeptDetails(){
        return departmentService.getAllDepartmentDetails();
    }

    @PostMapping("/department")
    public ResponseEntity<Department> saveDept(@RequestBody Department dept){
        return ResponseEntity.ok(departmentService.addDepartment(dept));
    }

    @GetMapping("/department/{deptId}")
    public ResponseEntity<Department> getDeptById(@PathVariable int deptId){
        return ResponseEntity.ok(departmentService.getDeptById(deptId));
    }

    @PutMapping("/department/{deptId}")
    public ResponseEntity<Department> updateDept(@PathVariable int deptId, @RequestBody Department dept){
        return ResponseEntity.ok(departmentService.updateDept(deptId, dept));
    }

    @DeleteMapping("/department/{deptId}")
    public ResponseEntity<String> deleteDept(@PathVariable int deptId){
        return ResponseEntity.ok(departmentService.deleteDept(deptId));
    }
}
