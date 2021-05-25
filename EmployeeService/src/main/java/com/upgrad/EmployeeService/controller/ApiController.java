package com.upgrad.EmployeeService.controller;

import com.upgrad.EmployeeService.entities.Employee;
import com.upgrad.EmployeeService.entities.Product;
import com.upgrad.EmployeeService.services.EmployeeService;
import com.upgrad.EmployeeService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProductService productService;


    @GetMapping("/employee/{id}")
    public Employee searchEmployeeByID(@PathVariable int id) {
        System.out.println("Searching Employee by ID  : " + id);
        Employee savedEmployee = employeeService.getEmployeeByID(id);
        return savedEmployee;
    }

    @GetMapping("/product/{id}")
    public String searchProductNameByID(@PathVariable int id) {
        System.out.println("Searching Product Name by ID  : " + id);
        Product productFromBackendService = productService.getProductByID(id);
        return productFromBackendService.getName();
    }

}
