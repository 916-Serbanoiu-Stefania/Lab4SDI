package com.example.SDIApp.Repositoriy;

import com.example.SDIApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
