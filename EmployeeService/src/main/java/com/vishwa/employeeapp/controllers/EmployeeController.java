package com.vishwa.employeeapp.controllers;

import com.vishwa.employeeapp.entities.Employee;
import com.vishwa.employeeapp.entities.Product;
import com.vishwa.employeeapp.services.EmployeeService;
import com.vishwa.employeeapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProductService productService;


    @GetMapping("/employees/{id}")
    public ResponseEntity searchEmployeeByID(@PathVariable("id") int id) {
        Employee savedEmployee = employeeService.getEmployeeByID(id);
        return new ResponseEntity(savedEmployee, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductNameByID(@PathVariable("id") int id) {
        Product savedProduct = productService.getProductByID(id);
        return new ResponseEntity(savedProduct.getName(), HttpStatus.OK);
    }

}
