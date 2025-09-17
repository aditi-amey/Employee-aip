package org.exampl.employeeapi.services;

import org.exampl.employeeapi.entities.EmployeeData;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Service
public class EmployeeService {
    private  String filename = "src/main/resource/employees.txt";

    // ***************Read file data******************
    public List<EmployeeData> buildEmployees () throws IOException {
        ArrayList<EmployeeData> employeeslist = new ArrayList<>();

        File file = new File(getClass().getClassLoader().getResource("employees.txt").getFile());

            try
                    (Scanner sc = new Scanner(file)) {
                boolean isline = true;

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (isline) {
                        isline = false;
                        continue;
                    }
                    if (line.isEmpty()) {
                        continue;
                    } else if (!line.contains(",")) {
                        continue;
                    }

                    String[] arr = line.split(",");
                    if (arr.length != 4) {
                        continue;
                    }
                    try {
                        int id = Integer.parseInt(arr[0].trim()); // trim remove extra space
                        String name = arr[1].trim();
                        double salary = Double.parseDouble(arr[2].trim());
                        String department = arr[3].trim();


                        //  object
                        EmployeeData e = new EmployeeData(id, name, salary, department);
                        employeeslist.add(e);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid row: " + line);
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }


            System.out.println("Emplooyees from file:");  // print all projects
            for (EmployeeData e : employeeslist) {
                System.out.println(e);
            }

            return employeeslist;
        }




//            // ***************SAVE EMPLOYEE data******************
//            public void saveEmployee(EmployeeData employee) throws IOException {
//                List<EmployeeData> employeesToSave = buildEmployees(); // read old data
//                employeesToSave.add(employee); // add new emp list contain old+new emp
//                writeEmployeesToFile(employeesToSave); // rewrite the file
//            }
    // ************* WRITE FILE code*****************
    public void writeEmployeesToFile(List<EmployeeData> employees) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("id,name,salary,department");  // write header
            bw.newLine();//move to the next line
            for (EmployeeData emp : employees) {
                bw.write(emp.getId() + "," +
                        emp.getEmployeeName() + "," +
                        emp.getEmployeeSalary() + "," +
                        emp.getEmployeeDept());
                bw.newLine();
            }

        }

    }
    // ***************SAVE EMPLOYEE data******************
    public void saveEmployee(EmployeeData employee) throws IOException {
        List<EmployeeData> employeesToSave = buildEmployees(); // read old data
        employeesToSave.add(employee); // add new emp list contain old+new emp
        writeEmployeesToFile(employeesToSave); // rewrite the file
    }
}


