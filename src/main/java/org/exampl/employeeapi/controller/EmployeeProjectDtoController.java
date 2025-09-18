package org.exampl.employeeapi.controller;

import org.exampl.employeeapi.dto.EmployeeDto;
import org.exampl.employeeapi.dto.EmployeeProjectDto;
import org.exampl.employeeapi.entities.Employees;
import org.exampl.employeeapi.services.EmployeeDtoServies;
import org.exampl.employeeapi.services.EmployeeProjectDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/employeeprojectdto")
public class EmployeeProjectDtoController {
    @Autowired
    EmployeeDtoServies employeeDtoServies;
    @Autowired
    EmployeeProjectDtoService employeeProjectDtoService;

    @PostMapping("/add")
    public ResponseEntity<Employees> addEmployeeWithProject(@RequestBody EmployeeProjectDto dto) {
        Employees savedEmployee = employeeProjectDtoService.saveEmployee(dto);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByName(@PathVariable String name) {
        List<EmployeeDto> employees = employeeDtoServies.getEmployeesByProjectName(name);
        return ResponseEntity.ok(employees);
    }
//    @GetMapping("/desc")
//    public ResponseEntity<List<EmployeeDto>> getEmployeesByName() {
//        List<EmployeeDto> employees = employeeDtoServies.getEmployeesByProject();
//        return ResponseEntity.ok(employees);
//    }

}
