package com.ecom.ECom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ECom.Model.Product;
import com.ecom.ECom.Repo.ProductRepo;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private ProductRepo productRepo;
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }
    
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepo.findById(id).orElseThrow();
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existingProduct = productRepo.findById(id).orElseThrow();
        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setQuantity(product.getQuantity());
        return productRepo.save(existingProduct);
    }


}
