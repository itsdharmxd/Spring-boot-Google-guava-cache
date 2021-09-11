package com.vishwa.employeeapp.services;

import com.vishwa.employeeapp.entities.Employee;
import com.vishwa.employeeapp.daos.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao _employeeDao;

    /**
     * Mimic a slow service
     * @param employeeId
     * @return
     */
    @Override
    public Employee getEmployeeByID(int employeeId) {
        /**
         * Business logic is taking time
         */


        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*7);
        }catch (Exception e){
            e.printStackTrace();
        }

        /**
         * DB is not taking time
         *
         * Cached the DB result and not call DB again for the same employeeID
         */
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
