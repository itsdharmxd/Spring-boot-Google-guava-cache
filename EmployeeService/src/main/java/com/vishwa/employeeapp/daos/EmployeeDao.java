package com.vishwa.employeeapp.daos;

import com.vishwa.employeeapp.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployeeDetails(int EmployeeId);
    List<Employee> getAllEmployee();
    Employee saveEmployeeDetails(Employee Employee);

}
