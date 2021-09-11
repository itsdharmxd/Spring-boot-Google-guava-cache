package com.vishwa.employeeapp.services;

import com.vishwa.employeeapp.entities.Employee;
import com.vishwa.employeeapp.daos.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao _employeeDao;

    @Override
    public Employee getEmployeeByID(int employeeId) {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*7);
        }catch (Exception e){
            e.printStackTrace();
        }
        return _employeeDao.getEmployeeDetails(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*7);
        }catch (Exception e){
            e.printStackTrace();
        }
        return _employeeDao.getAllEmployee();
    }

    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        _employeeDao.saveEmployeeDetails(employee);
        return employee;
    }
}
