package com.example.demo.service.Impl;

import com.example.demo.dto.BrandDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import com.example.demo.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private MappingService mappingService;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, MappingService mappingService) {
        this.brandRepository = brandRepository;
        this.mappingService = mappingService;
    }

    @Override
    public List<BrandDto> getBrands() {
        var brands = brandRepository.findAll();

        if (brands == null){
            throw new ResourceNotFoundException("Brands not found");
        }

        var brandDto = brands.stream().map(mappingService::mapProductBrandToDto).toList();

        return brandDto;
    }
}
