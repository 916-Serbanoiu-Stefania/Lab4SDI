package com.example.SDIApp.Service;

import com.example.SDIApp.Repositoriy.ProductRepository;
import com.example.SDIApp.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addService(Product new_product) { return productRepository.save(new_product); }

    public List<Product> addProductsListService(List<Product> products)
    {
        return productRepository.saveAll(products);
    }

    public  List<Product> getProductsService() { return productRepository.findAll(); }

    public Optional<Product> getService(Integer id) { return productRepository.findById(id); }

    public void deleteService(Integer id) { productRepository.deleteById(id); }

    public Product updateService(Integer id, Product newProduct)
    {
        Product p = productRepository.findById(id).orElse(null);

        p.setName(newProduct.getName());
        p.setMaterials(newProduct.getMaterials());
        p.setPrice(newProduct.getPrice());
        p.setWeight(newProduct.getWeight());

        return productRepository.save(p);
    }
}