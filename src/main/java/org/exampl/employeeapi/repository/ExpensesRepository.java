package org.exampl.employeeapi.repository;

import org.exampl.employeeapi.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Integer> {
//    List<Expenses> findByProject_Projectid(int projectid);

    List<Expenses> findByProject_ProjectName(String projectName);
}
