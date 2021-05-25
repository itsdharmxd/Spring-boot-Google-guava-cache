package com.upgrad.EmployeeService.repository;

import com.upgrad.EmployeeService.entities.Employee;
import com.upgrad.EmployeeService.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductDetails(int productId);
    List<Product> getAllProduct();
    Product saveProductDetails(Product product);

}
