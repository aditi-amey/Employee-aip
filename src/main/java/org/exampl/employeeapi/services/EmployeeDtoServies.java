package org.exampl.employeeapi.services;

import org.exampl.employeeapi.dto.EmployeeDto;
import org.exampl.employeeapi.dto.ProjectDto;
import org.exampl.employeeapi.entities.Employees;
import org.exampl.employeeapi.entities.Project;
import org.exampl.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDtoServies {
    @Autowired
    EmployeeRepository employeeRepo;

   public List<EmployeeDto> getEmployeesByProjectName(String projectName){
       List<Employees> employees = employeeRepo.findByProject_projectName(projectName);
//    public List<EmployeeDto> getEmployeesByProject(){
//        List<Employees> employees=employeeRepo.findAllByOrderByEmployeeSalaryDesc();
        List<EmployeeDto> employeeDtolist = new ArrayList<>();//emptylist

        for (Employees emp : employees) {
            Project project = emp.getProject();//fetch the project entities
            ProjectDto projectDto = new ProjectDto(
                    project.getProjectid(),
                    project.getProjectName(),
                    project.getProjectStatus(),
                    project.getProjectStartDate().toString()
            );
            employeeDtolist.add(new EmployeeDto(
                    emp.getId(),
                    emp.getEmployeeName(),
                    emp.getEmployeeSalary(),
                    emp.getEmployeeDept(),
                    projectDto
            ));
        }
            return employeeDtolist;
        }
    }
