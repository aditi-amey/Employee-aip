Employee-aip

A Spring Boot project to read and write employee data from files and expose REST API endpoints.
Features

1. Read Employee File

Endpoint:
GET:-

http://localhost:8080/api/employees/buildEmployeeList

Sample Request Body (JSON)

{

  "id": 111,
  
  "employeeName": "Aditi",
  
  "employeeSalary": 577866.0,
  
  "employeeDept": "Production"
  
}

2.Write employee data into a file

Endpoint:

post:-
http://localhost:8080/api/employees/addemp

 {
 
    "id": 201,
    
    "employeeName": "test1",
    
    "employeeSalary": 6000,
    
    "employeeDept": "IT"
  }

  Employee added:- test1 Total employees count:- 1
