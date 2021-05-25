package com.upgrad.EmployeeService.repository;

import com.upgrad.EmployeeService.entities.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static HashMap<Integer, Product> productData = new HashMap<>();

    @PostConstruct
    private void fillUsers() {
        productData.put(1, new Product(1,"Iphone",100000));
        productData.put(2, new Product(2,"Macbook",2100000));
        productData.put(3, new Product(3,"Nokia",45000));
        productData.put(4, new Product(4,"Cooker",4500));
        productData.put(5, new Product(5,"Washing Machine",12000));
        productData.put(6, new Product(6,"LEDTV",50000));
        productData.put(7, new Product(7,"HeadPhones",5000));
    }

    @Override
    public Product getProductDetails(int ProductId) {
       return productData.get(ProductId);
    }

    @Override
    public List<Product> getAllProduct() {
        Collection<Product> ProductCollection = productData.values();
        Iterator<Product> ProductIterator = ProductCollection.iterator();
        List<Product> Products = new ArrayList<>();
        while(ProductIterator.hasNext()){
            Products.add(ProductIterator.next());
        }
        return Products;
    }

    @Override
    public Product saveProductDetails(Product Product) {
        productData.put(Product.getId(), Product);
        return Product;
    }

}
