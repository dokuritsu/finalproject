package com.capgemini.finalproj.services;

import java.util.List;
import java.util.Optional;

import com.capgemini.finalproj.entities.Department;
import com.capgemini.finalproj.entities.Employee;
import com.capgemini.finalproj.entities.Project;
import com.capgemini.finalproj.exceptions.DeptNotFoundException;
import com.capgemini.finalproj.exceptions.EmployeeNotFoundException;
import com.capgemini.finalproj.exceptions.ExistingEmployeeException;
import com.capgemini.finalproj.exceptions.ProjectNotFoundException;
import com.capgemini.finalproj.repository.DepartmentRepo;
import com.capgemini.finalproj.repository.EmployeeRepo;
import com.capgemini.finalproj.repository.ProjectRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    DepartmentRepo deptRepo;

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee addEmployee(Employee emp) {
        Employee e = emp;
        if(employeeRepo.findById(e.getId()).isPresent()){
            throw new ExistingEmployeeException("This employee already exists...");
        }
        return employeeRepo.save(emp);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Unable to find employee with given id..."));
    }

    @Override
    public Employee updateEmployee(int id, Employee emp) {
        if(employeeRepo.findById(id).isPresent()){
            return employeeRepo.save(emp);
        } else {
            throw new EmployeeNotFoundException("Unable to update employee with given id...");
        }
    }

    @Override
    public String deleteEmployee(int id) {
        if(employeeRepo.findById(id).isPresent()){
            employeeRepo.deleteById(id);
            return "Employee successfully deleted";
        } else {
            throw new EmployeeNotFoundException("Unable to delete employee with given id...");
        }
    }

    @Override
    public Employee addProjectToEmployee(int id, int projId) {
        // Check to see if employee is already assigned to project
        if(employeeRepo.findById(id).isPresent()){
            if(projectRepo.findById(projId).isPresent()){
               Employee e = employeeRepo.findById(id).get();
               Project p = projectRepo.findById(projId).get();
               e.setProj(p);
               employeeRepo.save(e);
               return e;
            } else {
                throw new ProjectNotFoundException("Unable to find project with given projId...");
            }
        } else {
            throw new EmployeeNotFoundException("Unable to find employee with given empId...");
        }
    }

    @Override
    public Employee addDeptToEmployee(int id, int deptId) {
       if(employeeRepo.findById(id).isPresent()){
           if(deptRepo.findById(deptId).isPresent()){
               Employee e = employeeRepo.findById(id).get();
               Department d = deptRepo.findById(deptId).get();
               e.setDept(d);
               employeeRepo.save(e);
               return e;
           } else {
               throw new DeptNotFoundException("Unable to find department with given deptId...");
           }
       } else {
           throw new EmployeeNotFoundException("Unable to find employee with given empId...");
       }
    }

    
    
    
}
