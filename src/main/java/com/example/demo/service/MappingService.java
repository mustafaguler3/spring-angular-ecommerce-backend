package com.example.demo.service;

import com.example.demo.domain.Brand;
import com.example.demo.domain.Product;
import com.example.demo.domain.Type;
import com.example.demo.dto.BrandDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.TypeDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingService {

    private final ModelMapper modelMapper;

    @Autowired
    public MappingService(ModelMapper modelMapper) {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D map(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public ProductDto mapProductToProductDto(Product product) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(product, ProductDto.class);
    }

    public Product mapProductDtoToProduct(ProductDto productDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(productDto, Product.class);
    }

    public BrandDto mapProductBrandToDto(Brand productBrand) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(productBrand, BrandDto.class);
    }

    public Brand mapProductBrandDtoToEntity(BrandDto productBrandDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(productBrandDto, Brand.class);
    }

    public TypeDto mapProductTypeToDto(Type productType) {
        return modelMapper.map(productType, TypeDto.class);
    }

    public Type mapProductTypeDtoToEntity(TypeDto productTypeDto) {
        return modelMapper.map(productTypeDto, Type.class);
    }
}
