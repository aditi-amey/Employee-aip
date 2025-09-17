package org.exampl.employeeapi.entities;


public class
EmployeeData {
    private int id;
    private String employeeName;
    private double employeeSalary;
    private String employeeDept;


//    @ManyToOne
//    private EmployeeProject project;
    public EmployeeData(int id, String employeeName, double employeeSalary, String employeeDept) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDept = employeeDept;
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

    @Override
    public String toString() {
        return "EmployeeData{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeDept='" + employeeDept + '\'' +
                '}';
    }


}
