package com.capgemini.finalproj.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deptId")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    
    private String deptTitle;
    private String deptDesc;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "dept_movement")
    private List<Employee> employees;

    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getDeptTitle() {
        return deptTitle;
    }
    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }
    public String getDeptDesc() {
        return deptDesc;
    }
    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public String toString() {
        return "Department [deptDesc=" + deptDesc + ", deptId=" + deptId + ", deptTitle=" + deptTitle + ", employees="
                + employees + "]";
    }
}
