package com.practice.real_estate_management_system.entity_dto;

import com.practice.real_estate_management_system.estate_entity.PropertyStatus;
import com.practice.real_estate_management_system.estate_entity.PropertyType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private String address;

    private double price;

    private String ownerName;

    private PropertyType type;

    private PropertyStatus status;

    private List<String> property_services;

    private List<String> property_landmarks;
    private String description;
}
