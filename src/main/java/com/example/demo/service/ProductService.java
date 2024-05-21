package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    Page<ProductDto> getProducts(Pageable pageable);
    ProductDto getProductById(int id);
    List<ProductDto> searchProductByName(String keyword);
    List<ProductDto> searchByBrand(Integer brandId);
    List<ProductDto> searchByType(Integer typeId);
    List<ProductDto> searchByTypeAndBrand(Integer typeId,Integer brandId);
}
