package com.example.demo.service.Impl;

import com.example.demo.domain.Type;
import com.example.demo.dto.TypeDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TypeRepository;
import com.example.demo.service.MappingService;
import com.example.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
    private final MappingService mappingService;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository, MappingService mappingService) {
        this.typeRepository = typeRepository;
        this.mappingService = mappingService;
    }

    @Override
    public List<TypeDto> getTypes() {
        var types = typeRepository.findAll();

        if (types == null){
            throw new ResourceNotFoundException("Types not found");
        }
        var typesDto = types.stream().map(mappingService::mapProductTypeToDto).toList();

        return typesDto;
    }
}
