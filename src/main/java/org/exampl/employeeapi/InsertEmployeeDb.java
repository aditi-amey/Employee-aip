package org.exampl.employeeapi;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Component
public class InsertEmployeeDb {
     String url = "jdbc:mysql://localhost:3306/aditi";
    String user = "root";
     String password = "root";

    public void insertEmployees(EmployeeData employeesData) {
        String insertSQL = "INSERT INTO Employee (id, employeeName, employeeSalary, employeeDept) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement(insertSQL);

//            for (EmployeeData emp : employeesData) {
                ps.setInt(1, employeesData.getId());
                ps.setString(2, employeesData.getEmployeeName());
                ps.setDouble(3, employeesData.getEmployeeSalary());
                ps.setString(4, employeesData.getEmployeeDept());
                ps.executeUpdate();


            ps.close();
            con.close();
            System.out.println("Employees inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println( "Error inserting employees: " + e.getMessage());
        }
    }
}