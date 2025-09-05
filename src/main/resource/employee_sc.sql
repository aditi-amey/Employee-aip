
create database aditi;
use aditi;
CREATE TABLE Employees (
    id int primary key  NOT NULL,
    employeeName VARCHAR(100) NOT NULL,
    employeeSalary double NOT NULL,
    employeeDept VARCHAR(50) NOT NULL
);
desc employees;


insert INTO Employee (employeeName, employeeSalary, employeeDept) 
VALUES
('Amit', 50000.00, 'HR'),
('Priya', 65000.00, 'Finance'),
('Rahul', 55000.00, 'IT'),
('Sneha', 70000.00, 'Marketing'),
('Vikas', 60000.00, 'Sales');

commit;

select * from Employee;

desc employees;



