package com.upgrad.EmployeeService.controller;

import com.upgrad.EmployeeService.datacache.CacheStore;
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

    @Autowired
    CacheStore<String> productNameCache;

    @Autowired
    CacheStore<Employee> employeeCache;


    @GetMapping("/employee/{id}")
    public Employee searchEmployeeByID(@PathVariable int id) {
        System.out.println("Searching Employee by ID  : " + id);

        //Search Employee record in Cache
        Employee cachedEmpRecord = employeeCache.get(id);
        if(cachedEmpRecord != null) {
            System.out.println("Employee record found in cache : " + cachedEmpRecord.getName());
            return cachedEmpRecord;
        }

        //Fetch Employee record from backend service
        Employee EmpRecordFromBackendService = employeeService.getEmployeeByID(id);

        //Store Employee record in Cache
        employeeCache.add(id, EmpRecordFromBackendService);

        Employee savedEmployee = employeeService.getEmployeeByID(id);
        return savedEmployee;
    }

    @GetMapping("/product/{id}")
    public String searchProductNameByID(@PathVariable int id) {
        System.out.println("Searching Product Name by ID  : " + id);
        //Search Product Name in Cache
        String cachedProductName = productNameCache.get(id);
        if(cachedProductName != null) {
            System.out.println("Product name found in cache : " + cachedProductName);
            return cachedProductName;
        }

        //Fetch Product record from backend service
        Product productFromBackendService = productService.getProductByID(id);

        //Extract Product Name and Store in Cache
        productNameCache.add(id, productFromBackendService.getName());

        return productFromBackendService.getName();
    }

}
