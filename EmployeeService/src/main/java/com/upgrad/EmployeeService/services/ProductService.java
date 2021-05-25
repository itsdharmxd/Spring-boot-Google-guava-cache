package com.upgrad.EmployeeService.services;

import com.upgrad.EmployeeService.entities.Product;

import java.util.List;

public interface ProductService {
    Product getProductByID(int ProductId);
    List<Product> getAllProducts();
    Product saveProductDetails(Product Product);
}
