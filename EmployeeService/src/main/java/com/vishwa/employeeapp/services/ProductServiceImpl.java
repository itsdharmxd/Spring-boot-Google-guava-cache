package com.vishwa.employeeapp.services;

import com.vishwa.employeeapp.entities.Product;
import com.vishwa.employeeapp.daos.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao _productDao;

    @Override
    public Product getProductByID(int productId) {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return _productDao.getProductDetails(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            //Simulate backend service by forcing thread to sleep
            Thread.sleep(1000*5);
        }catch (Exception e){
            e.printStackTrace();
        }
        return _productDao.getAllProduct();
    }

    @Override
    public Product saveProductDetails(Product product) {
        _productDao.saveProductDetails(product);
        return product;
    }
}
