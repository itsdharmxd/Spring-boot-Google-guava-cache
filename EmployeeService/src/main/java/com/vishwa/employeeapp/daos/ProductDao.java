package com.vishwa.employeeapp.daos;

import com.vishwa.employeeapp.entities.Product;

import java.util.List;

public interface ProductDao {
    Product getProductDetails(int productId);
    List<Product> getAllProduct();
    Product saveProductDetails(Product product);

}
