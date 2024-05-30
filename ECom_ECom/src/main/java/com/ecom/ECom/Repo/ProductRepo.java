package com.ecom.ECom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ECom.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
