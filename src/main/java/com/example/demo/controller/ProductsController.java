package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.exception.GlobalExceptionHandling;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse<Page<ProductDto>> getProducts(
            @PageableDefault(size = 10)Pageable pageable,
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "brandId",required = false) Integer brandId,
            @RequestParam(value = "typeId",required = false) Integer typeId
            ) {
        var products = productService.getProducts(pageable);

        if (typeId != null){
            List<ProductDto> productDtos = productService.searchByType(typeId);
            Page<ProductDto> pagedList = new PageImpl<>(productDtos,pageable,productDtos.size());

            return new ApiResponse<>(HttpStatus.OK,"Success",pagedList);
        }

        if (brandId != null){
            List<ProductDto> productDtos = productService.searchByBrand(brandId);
            Page<ProductDto> paged = new PageImpl<>(productDtos,pageable,productDtos.size());

            return new ApiResponse<>(HttpStatus.OK,"Success",paged);
        }

        if (keyword != null && !keyword.isEmpty()){
            List<ProductDto> productDtos = productService.searchProductByName(keyword);
            Page<ProductDto> paged = new PageImpl<>(productDtos,pageable,productDtos.size());

            return new ApiResponse<Page<ProductDto>>(HttpStatus.OK, "Success Data Got",paged);
        }

        return new ApiResponse<Page<ProductDto>>(HttpStatus.OK,"Success Data",products);
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductDto> getProduct(@PathVariable("id") int id)  {
        var product = productService.getProductById(id);

        return new ApiResponse<>(HttpStatus.OK,product);
    }

}
















