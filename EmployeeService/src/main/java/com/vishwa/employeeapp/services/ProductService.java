package com.vishwa.employeeapp.services;

import com.vishwa.employeeapp.entities.Product;

import java.util.List;

public interface ProductService {
    Product getProductByID(int ProductId);
    List<Product> getAllProducts();
    Product saveProductDetails(Product Product);
}
