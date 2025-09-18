package org.exampl.employeeapi.dto;

public class EmployeeDto {
    private Integer  id;
    private String employeeName;
    private Double employeeSalary;
    private String employeeDept;
//    private int project_id;
     private ProjectDto projectDto;

    public EmployeeDto(Integer id, String employeeName, Double employeeSalary, String employeeDept, ProjectDto projectDto) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDept = employeeDept;
        this.projectDto = projectDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

//    public int getProject_id() {
//        return project_id;
//    }
//
//    public void setProject_id(int project_id) {
//        this.project_id = project_id;
//    }

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }
}
