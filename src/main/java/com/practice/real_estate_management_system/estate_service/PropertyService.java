package com.practice.real_estate_management_system.estate_service;

import com.practice.real_estate_management_system.estate_repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;

}
