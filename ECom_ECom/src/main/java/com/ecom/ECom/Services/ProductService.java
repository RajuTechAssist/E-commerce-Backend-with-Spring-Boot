package com.ecom.ECom.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ECom.Model.Product;
import com.ecom.ECom.Repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Optional<Product> getProductById(long id) {
        return productRepo.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product updateProduct(long id, Product updatedProduct) {
        // Find product, update the details and save
        // Handle error if product not found
        return productRepo.save(updatedProduct);
    }

    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }
}