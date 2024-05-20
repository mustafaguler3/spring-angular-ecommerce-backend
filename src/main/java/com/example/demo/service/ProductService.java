package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();
    ProductDto getProductById(int id);
}
