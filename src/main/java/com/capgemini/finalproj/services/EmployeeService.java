package com.capgemini.finalproj.services;

import java.util.List;

import com.capgemini.finalproj.entities.Employee;

public interface EmployeeService {
    public List<Employee> getAllEmployeeDetails();
    public Employee addEmployee(Employee emp);                          //Create
    public Employee getEmployeeById(int id);                            //Read
    public Employee updateEmployee(int id, Employee emp);               //Update
    public String deleteEmployee(int id);                               //Delete

    // Additional
    public Employee addProjectToEmployee(int id, int projId);
    public Employee addDeptToEmployee(int id, int deptId);
}
