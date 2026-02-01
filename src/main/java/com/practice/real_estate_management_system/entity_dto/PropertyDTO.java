package com.practice.real_estate_management_system.entity_dto;

import com.practice.real_estate_management_system.estate_entity.PropertyStatus;
import com.practice.real_estate_management_system.estate_entity.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String ownerName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyType type;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyStatus status;
    @ElementCollection
    @CollectionTable(name = "property_services")
    private List<String> property_services;
    @ElementCollection
    @CollectionTable(name = "property_landmarks")
    private List<String> property_landmarks;
    private String description;
}
