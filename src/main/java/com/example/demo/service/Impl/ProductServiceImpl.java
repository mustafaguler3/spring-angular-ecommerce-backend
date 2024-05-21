package com.example.demo.service.Impl;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.MappingService;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ProductDto> getProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);

        if (products == null){
            throw new ResourceNotFoundException("Products not found");
        }

        Page<ProductDto> productDto = products.map(mappingService::mapProductToProductDto);

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

    @Override
    public List<ProductDto> searchProductByName(String keyword) {
        List<Product> products = productRepository.searchByName(keyword);

        if (products == null){
            throw new ResourceNotFoundException("Product not found with by {}");
        }

        List<ProductDto> product = products.stream().map(mappingService::mapProductToProductDto)
                .collect(Collectors.toList());

        return product;
    }

    @Override
    public List<ProductDto> searchByBrand(Integer brandId) {
        List<Product> products = productRepository.searchByBrand(brandId);

        if (products == null){
            throw new ResourceNotFoundException("Products not found with {} type");
        }

        List<ProductDto> productDtos =
                products.stream().map(mappingService::mapProductToProductDto)
                        .collect(Collectors.toList());

        return productDtos;
    }

    @Override
    public List<ProductDto> searchByType(Integer typeId) {
        List<Product> products = productRepository.searchByType(typeId);

        if (products == null){
            throw new ResourceNotFoundException("Products not found with this type");
        }
        List<ProductDto> productDtos = products.stream()
                .map(mappingService::mapProductToProductDto)
                .collect(Collectors.toList());

        return productDtos;
    }

    @Override
    public List<ProductDto> searchByTypeAndBrand(Integer typeId, Integer brandId) {
        List<Product> products = productRepository.searchByTypeAndBrand(typeId,brandId);

        if (products == null){
            throw new ResourceNotFoundException("Products not found related to type and brand");
        }

        List<ProductDto> productDtos = products.stream().map(mappingService::mapProductToProductDto)
                .collect(Collectors.toList());

        return productDtos;
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




















