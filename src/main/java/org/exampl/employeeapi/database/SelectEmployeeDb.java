package org.exampl.employeeapi.database;

import org.exampl.employeeapi.entities.EmployeeData;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class SelectEmployeeDb {
    public List<EmployeeData> getAllSelectEmployee() {
        ArrayList<EmployeeData> employees= new ArrayList<>();
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/aditi";
        String username = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();

            //  Execute query
            String query = "SELECT id, employeeName,employeeSalary, employeeDept FROM employees";
            ResultSet resultSet = statement.executeQuery(query);

            // Process result set
            System.out.println("ID | employeeName | employeeSalary| employeeDept");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("employeeName");
                double salary = resultSet.getDouble("employeeSalary");
                String dept = resultSet.getString("employeeDept");
                EmployeeData emp = new EmployeeData(id, name, salary, dept);
                employees.add(emp);
            }
            for (EmployeeData emp : employees) {
                System.out.println(emp);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }


}


