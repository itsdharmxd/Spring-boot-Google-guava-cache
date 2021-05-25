package com.upgrad.EmployeeService.repository;

import com.upgrad.EmployeeService.entities.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getEmployeeDetails(int EmployeeId);
    List<Employee> getAllEmployee();
    Employee saveEmployeeDetails(Employee Employee);

}
