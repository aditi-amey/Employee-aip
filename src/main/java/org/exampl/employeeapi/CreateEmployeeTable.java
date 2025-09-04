package org.exampl.employeeapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEmployeeTable {
    public static void main(String[] args) {
        // JDBC connection details
        String url = "jdbc:mysql://localhost:3306/aditi";
        String user = "root";
        String password = "root";

        // DDL query
        String ddlQuery = "CREATE TABLE customers ("
                + "id INT PRIMARY KEY, "
                + "cutomerName VARCHAR(50), "
                + "cutomerSalary double, "


                + " cutomerLastName VARCHAR(50)"
                + ')';

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");//  Load MySQL driver
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            statement.executeUpdate(ddlQuery);
            System.out.println("created successfully.");


            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(" SQL Error: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println(" MySQL Driver not found");
        }
    }
}
