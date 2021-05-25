package com.upgrad.EmployeeService.repository;

import com.upgrad.EmployeeService.entities.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static HashMap<Integer,Employee> employeeData = new HashMap<>();

    @PostConstruct
    private void fillUsers() {
        employeeData.put(1, new Employee(1,"Ram","Manager"));
        employeeData.put(2, new Employee(2,"Mohan","Engineer"));
        employeeData.put(3, new Employee(3,"Shyam","Developer"));
        employeeData.put(4, new Employee(4,"James","QA"));
        employeeData.put(5, new Employee(5,"Ali","Auditor"));
        employeeData.put(6, new Employee(6,"John","CEO"));
        employeeData.put(7, new Employee(7,"Parvinder","CFO"));
    }

    @Override
    public Employee getEmployeeDetails(int EmployeeId) {
       return employeeData.get(EmployeeId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        Collection<Employee> EmployeeCollection = employeeData.values();
        Iterator<Employee> EmployeeIterator = EmployeeCollection.iterator();
        List<Employee> Employees = new ArrayList<>();
        while(EmployeeIterator.hasNext()){
            Employees.add(EmployeeIterator.next());
        }
        return Employees;
    }

    @Override
    public Employee saveEmployeeDetails(Employee Employee) {
        employeeData.put(Employee.getId(), Employee);
        return Employee;
    }

}
