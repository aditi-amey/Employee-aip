package org.exampl.employeeapi;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
@Component
public class InsertEmployeeDb {
      String url = "jdbc:mysql://localhost:3306/aditi";
      String user = "root";
      String password = "root";


        public String insertEmployees(List<EmployeeData> employees) {
            String insertSQL = "INSERT INTO employee (id, employeeName, employeeSalary, employeeDept) VALUES (?, ?, ?, ?)";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = con.prepareStatement(insertSQL);

                for (EmployeeData emp : employees) {
                    ps.setInt(1, emp.getId());
                    ps.setString(2, emp.getEmployeeName());
                    ps.setDouble(3, emp.getEmployeeSalary());
                    ps.setString(4, emp.getEmployeeDept());
                    ps.executeUpdate();
                }

                ps.close();
                con.close();
                return "Employees inserted successfully!";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error inserting employees: " + e.getMessage();
            }
        }
    }