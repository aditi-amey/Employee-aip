package org.exampl.employeeapi.controller;
import org.exampl.employeeapi.entities.Project;
import org.exampl.employeeapi.ProjectEmployee;
import org.exampl.employeeapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
   @Autowired
   ProjectRepository objProjectRepo;

    @GetMapping("/projectCount")
    public List<ProjectEmployee> getAllProjectCount()  {
        return  objProjectRepo.getProjectEmployeeCounts();
    }
    @PostMapping("/Projectjpa")
    public void addProjectJPA(@RequestBody Project project) {
        System.out.println("employees = " + project);
        objProjectRepo.save(project);
    }
    @GetMapping("/Count")
    public List<ProjectEmployee> getAllProjectByCount()  {
        return  objProjectRepo.findProjectEmployeeByCounts();
    }
    @GetMapping("/status/{projectStatus}")
    public  List<ProjectEmployee>getProjectStatus(@PathVariable String projectStatus){
        return objProjectRepo.findProjectStatus(projectStatus);
    }
//    @GetMapping("/date/{projectStartDate}")
//    public  List<ProjectEmployee>getProjectDate(@PathVariable String projectStartDate) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date parsedDate = sdf.parse(projectStartDate);
//        return objProjectRepo.findProjectStart(parsedDate);
//    }
    @GetMapping("/date/{Date}")
    public  List<ProjectEmployee>getProjectDate(@PathVariable String Date) {
               return objProjectRepo.findProjectStart(Date);
    }
    @GetMapping("/before/{projectstartdate}")
    public List<Project> getAllEmployeeSalaryDESC(@PathVariable String projectstartdate) throws ParseException  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = sdf.parse(projectstartdate);
            return objProjectRepo.findByProjectStartDate(parsedDate);
        }
    }


