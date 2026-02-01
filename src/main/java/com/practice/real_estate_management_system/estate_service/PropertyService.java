package com.practice.real_estate_management_system.estate_service;
import com.practice.real_estate_management_system.entity_dto.PropertyDTO;
import com.practice.real_estate_management_system.estate_entity.Property;
import com.practice.real_estate_management_system.estate_repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
