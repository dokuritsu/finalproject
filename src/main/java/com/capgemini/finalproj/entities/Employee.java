package com.capgemini.finalproj.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "employees", schema = "finalproject")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String designation;
    private double salary;

    // Each employee has one address; Unidirectional
    @Embedded
    private Address address;

    // Each employee will work on one project; Bidirectional
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "proj_id", referencedColumnName = "projId", nullable = true)
    @JsonBackReference(value = "proj_movement")
    private Project proj;

    // Each employee will have one department; Bidirectional
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dept_id", referencedColumnName = "deptId", nullable = true)
    @JsonBackReference(value = "dept_movement")
    private Department dept;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String position) {
        this.designation = position;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Project getProj() {
        return proj;
    }
    public void setProj(Project proj) {
        this.proj = proj;
    }
    public Department getDept() {
        return dept;
    }
    public void setDept(Department dept) {
        this.dept = dept;
    }
    @Override
    public String toString() {
        return "Employee [address=" + address + ", dept=" + dept + ", designation=" + designation + ", id=" + id
                + ", name=" + name + ", proj=" + proj + ", salary=" + salary + "]";
    }
}
