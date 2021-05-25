package com.capgemini.finalproj.services;

import java.util.List;

import com.capgemini.finalproj.entities.Department;

public interface DepartmentService {
    public List<Department> getAllDepartmentDetails();
    public Department addDepartment(Department dept);               //Create
    public Department getDeptById(int deptId);                   //Read
    public Department updateDept(int deptId, Department dept);                  //Update
    public String deleteDept(int deptId);                      //Delete
}
