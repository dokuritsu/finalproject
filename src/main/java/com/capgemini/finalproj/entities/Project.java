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

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "projId")
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projId;

    private String projName;
    private String projDesc;

    @OneToMany(mappedBy = "proj", cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "proj_movement")
    List<Employee> employees;
    
    public int getProjId() {
        return projId;
    }
    public void setProjId(int projId) {
        this.projId = projId;
    }
    public String getProjName() {
        return projName;
    }
    public void setProjName(String projName) {
        this.projName = projName;
    }
    public String getProjDesc() {
        return projDesc;
    }
    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public String toString() {
        return "Project [employees=" + employees + ", projDesc=" + projDesc + ", projId=" + projId + ", projName="
                + projName + "]";
    }
}
