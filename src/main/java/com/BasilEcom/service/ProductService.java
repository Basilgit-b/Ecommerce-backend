package com.BasilEcom.service;

import com.BasilEcom.dto.ProductRequestDTO;
import com.BasilEcom.dto.ProductResponseDTO;
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
    public ProductResponseDTO createProduct(ProductRequestDTO dto)
    {
        Product product= new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        Product saved= productRepository.save(product);

        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());
        response.setPrice(saved.getPrice());
        response.setQuantity(saved.getQuantity());
        return response;
    }
    public List<ProductResponseDTO> getAllProduct()
    {
        return productRepository.findAll()
                .stream().map(product->{
                    ProductResponseDTO dto= new  ProductResponseDTO();
                    dto.setId(product.getId());
                    dto.setName(product.getName());
                    dto.setDescription(product.getDescription());
                    dto.setPrice(product.getPrice());
                    dto.setQuantity(product.getQuantity());
                    return dto;
                }).toList();
    }
}
