package com.upgrad.EmployeeService.services;

import com.upgrad.EmployeeService.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByID(int employeeId);
    List<Employee> getAllEmployees();
    Employee saveEmployeeDetails(Employee employee);
}
