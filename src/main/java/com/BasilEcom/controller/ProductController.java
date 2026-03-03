package com.BasilEcom.controller;

import com.BasilEcom.dto.ProductRequestDTO;
import com.BasilEcom.dto.ProductResponseDTO;
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
    public ProductResponseDTO create(@RequestBody ProductRequestDTO dto)
    {
        return productService.createProduct(dto);
    }
    @GetMapping("/all")
    public List<ProductResponseDTO> create()
    {
        return productService.getAllProduct();
    }

}
