package org.exampl.employeeapi.services;

import org.exampl.employeeapi.dto.EmployeeDto;
import org.exampl.employeeapi.dto.EmployeeProjectDto;
import org.exampl.employeeapi.dto.ProjectDto;
import org.exampl.employeeapi.entities.Employees;
import org.exampl.employeeapi.entities.Project;
import org.exampl.employeeapi.repository.EmployeeRepository;
import org.exampl.employeeapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProjectDtoService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    public Employees saveEmployee(EmployeeProjectDto dto) {
        //create object in project
        Project pro = new Project();
        pro.setProjectid(dto.getProjectId());
        pro.setProjectName(dto.getProjectName());
        pro.setProjectStatus(dto.getProjectStatus());
        pro.setProjectStartDate(java.sql.Date.valueOf(dto.getProjectStartDate()));
        // Save Project (if not exists)

        projectRepository.save(pro);
           //create object in employees
        Employees emp = new Employees();
        emp.setId(dto.getId());
        emp.setEmployeeName(dto.getEmployeeName());
        emp.setEmployeeSalary(dto.getEmployeeSalary());
        emp.setEmployeeDept(dto.getEmployeeDept());
        emp.setProject(pro);

//        employeeRepository.save(Employees);
        return employeeRepository.save(emp);
    }



}
