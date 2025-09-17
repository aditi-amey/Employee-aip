package org.exampl.employeeapi.repository;

import org.exampl.employeeapi.EmployeeProject;
import org.exampl.employeeapi.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
   List<Employees> findByEmployeeName(String name);

    List<Employees> findByProjectId(long projectId);

    List<Employees> findByProject_projectName(String projectName);

    List<Employees> findAllByOrderByEmployeeSalaryDesc();

//    List<Employees>find(@Param("salary")double salary);


    @Query(value = "SELECT p.projectname AS projectName, e.employeeName AS employeesName " +
            "FROM employees e " +
            "JOIN project p " +
            "ON e.project_id = p.projectid " +
            "WHERE e.employeeName = :name",
            nativeQuery = true)
    List<EmployeeProject> findProjectByEmployeeName(@Param("name") String name);

    @Query(value = " SELECT e.employeeName as employeesName,p.projectName as projectName" +
            " FROM employees e" +
            " JOIN project p" +
            " ON e.project_id=p.projectId" +
            " WHERE p.projectName=:projectName",
            nativeQuery = true)
    List<EmployeeProject>findProjectByProjectName(@Param("projectName")String projectName );


//    -- Show employee names and their salaries in descending order of salary.
           @Query( value = "SELECT e.employeeName as employeesName," +
                   "e.employeeSalary as employeeSalary,"+
                   "p.projectName as projectName " +
                            "FROM employees e " +
                              "JOIN project p " +
                               "ON e.project_id = p.projectid " +
                             "ORDER BY e.employeeSalary DESC",
                               nativeQuery = true)
    List<EmployeeProject>findSalaryInDESC();

//-- Show all employees whose salary is greater than 50000.
 @Query(value = "SELECT  e.employeeName as employeesName,e.employeeSalary as employeeSalary," +
          "p.projectName as projectName " +
           "FROM employees e " +
          "JOIN project p " +
          "ON e.project_id = p.projectid " +
    "WHERE e.employeeSalary > :salary",
         nativeQuery = true)
    List<EmployeeProject>findEmployeeGrt(@Param("salary")double salary);
//-- Show department-wise maximum and minimum salaries.
          @Query(value = " SELECT e.employeeDept as employeeDept ,"+
                  "MAX(employeeSalary) AS maxSalary,"+
                   "MIN(employeeSalary) AS minSalary "+
                     "FROM employees e "+
                  "GROUP BY employeeDept",nativeQuery = true)
    List<EmployeeProject>findDeptWiseSalary();

}

