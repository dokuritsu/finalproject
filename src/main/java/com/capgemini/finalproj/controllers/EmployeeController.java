package com.capgemini.finalproj.controllers;

import java.util.List;
import java.util.Optional;

import com.capgemini.finalproj.entities.Employee;
import com.capgemini.finalproj.exceptions.EmployeeNotFoundException;
import com.capgemini.finalproj.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployeeDetails(){
        return employeeService.getAllEmployeeDetails();
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        return ResponseEntity.ok(employeeService.addEmployee(emp));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return ResponseEntity.ok(employeeService.updateEmployee(id, emp));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @PutMapping("/employee/{id}/proj/{projId}")
    public ResponseEntity<Employee> addProjectToEmployee(@PathVariable int id, @PathVariable int projId){
        return ResponseEntity.ok(employeeService.addProjectToEmployee(id, projId));
    }

    @PutMapping("/employee/{empId}/dept/{deptId}")
    public ResponseEntity<Employee> addDeptToEmployee(@PathVariable int empId, @PathVariable int deptId){
        return ResponseEntity.ok(employeeService.addDeptToEmployee(empId, deptId));
    }
}
