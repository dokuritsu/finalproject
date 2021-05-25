package com.capgemini.finalproj.services;

import java.util.List;

import com.capgemini.finalproj.entities.Department;
import com.capgemini.finalproj.entities.Employee;
import com.capgemini.finalproj.exceptions.DeptNotFoundException;
import com.capgemini.finalproj.exceptions.ExistingDeptException;
import com.capgemini.finalproj.repository.DepartmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepo deptRepo;

    @Override
    public List<Department> getAllDepartmentDetails() {
        return deptRepo.findAll();
    }

    @Override
    public Department addDepartment(Department dept) {
        if(deptRepo.findById(dept.getDeptId()).isPresent()){
            throw new ExistingDeptException("This deptartment already exists...");
        }
        return deptRepo.save(dept);
    }

    @Override
    public Department getDeptById(int deptId) {
        return deptRepo.findById(deptId).orElseThrow(() -> new DeptNotFoundException("Unable to find deptarment with given deptId..."));
    }

    @Override
    public Department updateDept(int deptId, Department dept) {
        if(deptRepo.findById(deptId).isPresent()){
            return deptRepo.save(dept);
        } else {
            throw new DeptNotFoundException("Unable to find department with given deptId...");
        }
    }

    @Override
    public String deleteDept(int deptId) {
        if(deptRepo.findById(deptId).isPresent()){
            Department d = deptRepo.findById(deptId).get();
            if((d.getEmployees()!=null) && (!d.getEmployees().isEmpty())){
                for(Employee e: d.getEmployees()){
                    e.setDept(null);
                }
            }
            deptRepo.deleteById(deptId);
            return "Department successfully deleted...";
        } else {
            throw new DeptNotFoundException("Unable to find department with given deptId...");
        }
    }
    
}
