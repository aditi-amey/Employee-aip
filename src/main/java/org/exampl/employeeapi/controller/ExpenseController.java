package org.exampl.employeeapi.controller;

import org.exampl.employeeapi.entities.Employees;
import org.exampl.employeeapi.entities.Expenses;
import org.exampl.employeeapi.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired
    ExpensesRepository objExpensesRepo;

//    @GetMapping("/expenses/{projectid}")
//    public List<Expenses> getAllProjectByExpensesId(@PathVariable int projectid) {
//        return objExpensesRepo.findByProject_Projectid(projectid);
//
//    }
    @GetMapping("/project/{projectName}")
    public List<Expenses>getAllProjectByExpensesName(@PathVariable String projectName) {
        return objExpensesRepo.findByProject_ProjectName(projectName);
}
    }