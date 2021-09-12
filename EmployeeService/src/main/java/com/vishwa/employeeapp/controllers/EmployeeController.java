package com.vishwa.employeeapp.controllers;

import com.vishwa.employeeapp.cachestore.CacheStore;
import com.vishwa.employeeapp.entities.Employee;
import com.vishwa.employeeapp.entities.Product;
import com.vishwa.employeeapp.services.EmployeeService;
import com.vishwa.employeeapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
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
@Autowired
    private CacheStore<Employee> cacheStore;

    @GetMapping("/employees/{id}")
    public ResponseEntity searchEmployeeByID(@PathVariable("id") int id) {
        /**
         *
         * Write the caching logic with Guava cache
         * first time call the service for id
         *
         * cache it locally
         *
         * next time returne the cached result for the same id
         */

        Employee savedEmployee =cacheStore.get(id);
         if(savedEmployee!=null){

         }else {
          savedEmployee=    employeeService.getEmployeeByID(id);
             cacheStore.add(id,savedEmployee);
         }



        return new ResponseEntity(savedEmployee, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductNameByID(@PathVariable("id") int id) {

        /**
         * Write the caching logic with Guava cache
         */
        Product savedProduct = productService.getProductByID(id);
        return new ResponseEntity(savedProduct.getName(), HttpStatus.OK);
    }

}
