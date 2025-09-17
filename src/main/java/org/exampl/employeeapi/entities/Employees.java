package org.exampl.employeeapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employees {
    @Id
    @Column(name="id")
    private int id;
    @Column(nullable = false)
    private String employeeName;
    @Column
    private double employeeSalary;
    @Column
    private String employeeDept;

    @Column(name = "project_id",insertable = false,updatable = false)
    private int projectId;

    @ManyToOne
    @JoinColumn(name="project_id")
   private Project project;


    public Employees(int id, String employeeName, double employeeSalary, String employeeDept) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDept = employeeDept;

    }
    public Employees() {

    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }


}

