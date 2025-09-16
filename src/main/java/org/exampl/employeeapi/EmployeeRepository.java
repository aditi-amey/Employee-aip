package org.exampl.employeeapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
   List<Employees> findByEmployeeName(String name);
//    @Query(value = "select employeeName,projectname" +
//            " from employees e" +
//            " join project p" +
//            "  on e.project_id=p.projectid" +
//            " where employeeName=:Name",nativeQuery = true)
//    List<EmployeeProject>findProjectByEmployeeName(@Param("Name")String employeeName);
List<Employees> findByProjectId(long projectid);
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

