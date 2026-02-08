package com.practice.real_estate_management_system.estate_service;
import com.practice.real_estate_management_system.entity_dto.PropertyDTO;
import com.practice.real_estate_management_system.estate_entity.Property;
import com.practice.real_estate_management_system.estate_entity.PropertyStatus;
import com.practice.real_estate_management_system.estate_entity.PropertyType;
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

    //delete-property-by-id-function
    public String deletePropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElseThrow(()->new RuntimeException("Property id "+id+" not found"));
        propertyRepository.deleteById(id);
        return "Property with id "+id+" deleted";
    }

    //update-property-by-id-function
    public PropertyDTO updatePropertyById(Long id,PropertyDTO propertyDTO) {
        Property property = propertyRepository.findById(id).orElseThrow(()->new RuntimeException("Property with id "+id+" not found"));
        modelMapper.map(propertyDTO,property);
        property = propertyRepository.save(property);
        return modelMapper.map(property,PropertyDTO.class);
    }
    //find-properties-by-type
    public List<PropertyDTO> getAllPropertiesByPropertyType(PropertyType propertyType) {
        List<Property> propertyList = propertyRepository.findByType(propertyType);
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for(Property property : propertyList) {
            propertyDTOList.add(modelMapper.map(property,PropertyDTO.class));
        }
        return propertyDTOList;
    }
    //find-properties-by-status
    public List<PropertyDTO> getAllPropertiesByPropertyStatus(PropertyStatus propertyStatus) {
        List<Property> propertyList = propertyRepository.findByStatus(propertyStatus);
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for(Property property : propertyList) {
            propertyDTOList.add(modelMapper.map(property,PropertyDTO.class));
        }
        return propertyDTOList;
    }
    //find-properties-by-owner-name
    public List<PropertyDTO> getAllPropertiesByOwnerName(String ownerName) {
        List<Property> propertyList = propertyRepository.findByOwnerName(ownerName);
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for(Property property : propertyList) {
            propertyDTOList.add(modelMapper.map(property,PropertyDTO.class));
        }
        return propertyDTOList;
    }
}
