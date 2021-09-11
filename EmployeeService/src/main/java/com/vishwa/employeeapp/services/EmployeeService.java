package com.vishwa.employeeapp.services;

import com.vishwa.employeeapp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByID(int employeeId);

    List<Employee> getAllEmployees();

    Employee saveEmployeeDetails(Employee employee);
}
