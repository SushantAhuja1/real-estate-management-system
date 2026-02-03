package com.practice.real_estate_management_system.estate_controller;

import com.practice.real_estate_management_system.entity_dto.PropertyDTO;
import com.practice.real_estate_management_system.estate_service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    //add-property-controller
    @PostMapping()
    public PropertyDTO addProperty(@RequestBody PropertyDTO propertyDTO){
        return propertyService.addProperty(propertyDTO);
    }
    //get-all-properties-controller
    @GetMapping()
    public List<PropertyDTO> getAllProperties(){
        return propertyService.getAllProperties();
    }
    //get-property-by-id-controller
    @GetMapping("/{id}")
    public PropertyDTO getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }
    //delete-property-by-id-controller
    @DeleteMapping("/{id}")
    public String deletePropertyById(@PathVariable Long id) {
        return propertyService.deletePropertyById(id);
    }
    //update-property-by-id-controller
    @PutMapping("/{id}")
    public PropertyDTO updatePropertyById(@PathVariable Long id,@ RequestBody PropertyDTO propertyDTO){
        return propertyService.updatePropertyById(id,propertyDTO);
    }
}
