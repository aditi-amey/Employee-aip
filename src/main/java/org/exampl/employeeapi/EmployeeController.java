package org.exampl.employeeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    public List<EmployeeData> employeesFromPost = new ArrayList<EmployeeData>();

    //************************read write file ******************************
    @Autowired
    public EmployeeService objEmployeeService;

    @GetMapping("/buildEmployeeList")
    public List<EmployeeData> getAllEmployees() throws IOException {
        System.out.println("getAllEmployees");
        List<EmployeeData> employeesFromFile = objEmployeeService.buildEmployees();
        employeesFromFile.addAll(employeesFromPost);
        return employeesFromFile;
    }

    @GetMapping("/{id}")
    public EmployeeData getEmployeeById(@PathVariable int id) {
        return employeesFromPost.stream()
                .filter(emp -> emp.getId() == id)  // use == for primitive int
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/addemp")
    public String addEmployeeData(@RequestBody EmployeeData employeeData) throws IOException {
        if (employeeData == null || employeeData.getEmployeeName() == null || employeeData.getEmployeeName().isEmpty()) {
            throw new RuntimeException("Employee name is null or empty");
        }
        employeesFromPost.add(employeeData);//add to file
        objEmployeeService.saveEmployee(employeeData); // save to file
        System.out.println("employee = " + employeesFromPost.size());
        return "Employee added:- " + employeeData.getEmployeeName() +
                " Total employees count:- " + employeesFromPost.size();
    }
    //************************read write file ******************************

    //************************Select Insert database ******************

    @Autowired
    private InsertEmployeeDb objinsertEmployeeDb;
    @Autowired
    public SelectEmployeeDb objSelectEmployee;

    @GetMapping("/selectemployee")
    public List<EmployeeData> getAllSelectEmployee() throws IOException {
        System.out.println("Fetching all employees from DB...");
        return objSelectEmployee.getAllSelectEmployee();  // 👈 directly return DB list
    }

    @PostMapping("/insert")
    public void insertEmployees(@RequestBody EmployeeData employees) {
        System.out.println("employees = " + employees);
        if (employees == null) {
            throw new RuntimeException("Employee mandatory");
        }

        objinsertEmployeeDb.insertEmployees(employees);

    }

    //************************Select Insert database ******************


@Autowired
EmployeeRepository  objEmployeeRepository;

   @GetMapping("/jpaemployee")
public List<Employees> getAllEmployeesJPA()  {
    System.out.println("Fetching all getAllEmployeesJPA...");
//    List<Employees>EmployeeList=
    return  objEmployeeRepository.findAll();

}
@PostMapping("/addjpa")
    public void addEmployeesJPA(@RequestBody Employees employee) {
       System.out.println("employees = " + employee);
   objEmployeeRepository.save(employee);
}
}





//    @GetMapping("/selectemployee")
//    public List<EmployeeData> getAllSelectEmployee() throws IOException {
//      System.out.println("getAllEmployees");
//  List<EmployeeData> employees= objSelectEmployee.getAllSelectEmployee();
//        employees.addAll(employees);
//        return employees;
//    }

    //************************Select Insert database ******************






//    @DeleteMapping("/delete/{id}")
//    public String deleteEmployeeData(@PathVariable int id) {
//        boolean removed = employeesFromPost.removeIf(emp -> emp.getId() == id);
//        if (removed) {
//            return "Employee deleted: " + employeesFromPost.size();
//        } else {
//            return "Employee with ID " + id + " not found.";
//        }
//    }


//    @PutMapping("/update/{id}")
//    public String updateEmployeeData(@PathVariable int id, @RequestBody EmployeeData updatedEmployee) throws IOException {
//        List<EmployeeData> allEmployees = getAllEmployees();
//        for (EmployeeData emp : allEmployees) {
//            if (emp.getId() == id) {
//                emp.setEmployeeName(updatedEmployee.getEmployeeName());
//                emp.setEmployeeSalary(updatedEmployee.getEmployeeSalary());
//                emp.setEmployeeDept(updatedEmployee.getEmployeeDept());
//                return "Employee updated: " + emp;
//            }
//        }
//        return "Employee with ID " + id + " not found.";
//    }





