package com.BasilEcom.service;

import com.BasilEcom.entity.Product;
import com.BasilEcom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }
    public Product createProduct(Product product)
    {
        return productRepository.save(product);
    }
    public List<Product> getAllProduct()
    {
        return productRepository.findAll();
    }
}
