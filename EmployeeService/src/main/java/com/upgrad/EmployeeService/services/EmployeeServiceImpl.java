package com.upgrad.EmployeeService.services;

import com.upgrad.EmployeeService.entities.Employee;
import com.upgrad.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByID(int employeeId) {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeeRepository.getEmployeeDetails(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeeRepository.getAllEmployee();
    }

    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        employeeRepository.saveEmployeeDetails(employee);
        return employee;
    }
}
