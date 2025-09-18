package org.exampl.employeeapi.repository;

//import org.exampl.employeeapi.ProjectEmployee;
import org.exampl.employeeapi.ProjectEmployee;
import org.exampl.employeeapi.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {

@Query(value = "SELECT p.projectname AS projectName, COUNT(e.id) AS totalEmployees " +
        "FROM project p  JOIN employees e ON p.projectid = e.project_id " +
        "GROUP BY p.projectname",
        nativeQuery = true)
List<ProjectEmployee> getProjectEmployeeCounts();

@Query(value = "SELECT COUNT(e.id) AS totalEmployees " +
        "FROM project p JOIN employees e ON p.projectid = e.project_id",
        nativeQuery = true)
List<ProjectEmployee> findProjectEmployeeByCounts();

@Query(value = " select p.projectName as projectName ,p.projectStatus as projectStatus"+
                " from project p"+
                " where p.projectStatus=:projectStatus",nativeQuery = true)
    List<ProjectEmployee>findProjectStatus(@Param("projectStatus")String projectStatus);


//-- List employees whose project started before '2025-01-01'.
    @Query(value = "SELECT e.employeeName as employeeName, p.projectName as projectName," +
            " p.projectStartDate as projectStartDate "+
                    "FROM employees e "+
                    "JOIN project p ON e.project_id = p.projectid "+
                     "WHERE p.projectStartDate < :Date",nativeQuery = true)
    List<ProjectEmployee>findProjectStart(@Param("Date") String Date);

   List<Project>findByProjectStartDate(Date projectstartdate);
//    List<Project>findByProjectStartDateBefore(Date projectstartdate);
//    List<Project>findByProjectStartDateAfter(Date projectstartdate);


}
