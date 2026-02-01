package com.practice.real_estate_management_system.estate_service;
import com.practice.real_estate_management_system.entity_dto.PropertyDTO;
import com.practice.real_estate_management_system.estate_entity.Property;
import com.practice.real_estate_management_system.estate_repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final ModelMapper modelMapper;

    //add-property-function
    public PropertyDTO addProperty(PropertyDTO propertyDTO) {
        Property property = modelMapper.map(propertyDTO, Property.class);
        property = propertyRepository.save(property);
        return modelMapper.map(property, PropertyDTO.class);
    }

    //list-all-properties-function
    public List<PropertyDTO> getAllProperties() {
        List<Property> propertyList = propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        propertyList.forEach(property -> {
            propertyDTOList.add(modelMapper.map(property,PropertyDTO.class));
        });
        return propertyDTOList;
    }

    //find-property-by-id-function
    public PropertyDTO getPropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElseThrow(()->new RuntimeException("Property with id "+id+" not found"));
        return modelMapper.map(property,PropertyDTO.class);
    }
}
