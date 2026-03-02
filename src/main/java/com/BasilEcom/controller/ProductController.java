package com.BasilEcom.controller;

import com.BasilEcom.entity.Product;
import com.BasilEcom.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }
    @PostMapping("/create")
    public Product create(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }
    @GetMapping("/all")
    public List<Product> create()
    {
        return productService.getAllProduct();
    }

}
