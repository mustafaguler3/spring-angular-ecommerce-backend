package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.exception.GlobalExceptionHandling;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController  {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ApiResponse<List<ProductDto>> getProducts() {
        var products = productService.getProducts();

        return new ApiResponse<List<ProductDto>>(HttpStatus.OK,"Products got success",products);
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductDto> getProduct(@PathVariable("id") int id)  {
        var product = productService.getProductById(id);

        return new ApiResponse<>(HttpStatus.OK,product);
    }

}
















