package com.vishwa.employeeapp.services;

import com.vishwa.employeeapp.entities.Product;

import java.util.List;

public interface ProductService {

    Product getProductByID(int productId);

    List<Product> getAllProducts();

    Product saveProductDetails(Product Product);
}
