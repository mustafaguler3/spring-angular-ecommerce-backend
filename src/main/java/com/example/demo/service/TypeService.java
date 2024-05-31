package com.example.demo.service;

import com.example.demo.domain.Type;
import com.example.demo.dto.TypeDto;

import java.util.List;

public interface TypeService {
    List<TypeDto> getTypes();
}
