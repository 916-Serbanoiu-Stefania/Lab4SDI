package com.example.SDIApp.API;

import com.example.SDIApp.Model.Product;
import com.example.SDIApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addService(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getProductsService();
    }

    @GetMapping("/get/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id) {
        return productService.getService(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteService(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.updateService(id, product);
    }
}
