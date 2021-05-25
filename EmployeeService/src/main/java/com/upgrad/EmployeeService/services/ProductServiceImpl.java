package com.upgrad.EmployeeService.services;

import com.upgrad.EmployeeService.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    com.upgrad.EmployeeService.repository.ProductRepository productRepository;

    @Override
    public Product getProductByID(int productId) {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return productRepository.getProductDetails(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return productRepository.getAllProduct();
    }

    @Override
    public Product saveProductDetails(Product product) {
        productRepository.saveProductDetails(product);
        return product;
    }
}
