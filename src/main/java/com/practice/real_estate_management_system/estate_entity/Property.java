package com.practice.real_estate_management_system.estate_entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
