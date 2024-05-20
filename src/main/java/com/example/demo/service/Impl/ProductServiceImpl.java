package com.example.demo.service.Impl;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.MappingService;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MappingService mappingService;

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();

        if (products == null){
            throw new ResourceNotFoundException("Products not found");
        }

        List<ProductDto> productDto = products.stream().map(mappingService::mapProductToProductDto).collect(Collectors.toList());

        return productDto;
    }

    @Override
    public ProductDto getProductById(int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        log.info("Product with id {}",product);
        ProductDto returnedProduct = mappingService.mapProductToProductDto(product);
        log.info("Product with id {}",returnedProduct);
        return returnedProduct;
    }

    private ProductDto productToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice().longValue())
                .pictureUrl(product.getPictureUrl())
                .productBrand(product.getBrand().getName())
                .productType(product.getType().getName())
                .build();

    }
}




















